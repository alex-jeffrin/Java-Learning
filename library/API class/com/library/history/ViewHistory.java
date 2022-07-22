package com.library.history;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class HistoryList{
    List<History>List;

    public HistoryList() {
    }

    public HistoryList(java.util.List<History> list) {
        List = list;
    }

    public java.util.List<History> getList() {
        return List;
    }

    public void setList(java.util.List<History> list) {
        List = list;
    }
}

class History {

    String time;
    String event;
    String action;

    History(String time, String event, String action){
        this.time  = time ;
        this.event = event ;
        this.action = action ;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}


@Path("history")
public class ViewHistory {

    public ArrayList<History> returnList = new ArrayList<>();

    @Path("showhistory")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public HistoryList showHistory() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String jdbcURL = "jdbc:postgresql://localhost:5432/LibraryDatabase";
        String username = "postgres";
        String password = "root";
        Connection connection = DriverManager.getConnection(jdbcURL,username,password   );
        Statement statement = connection.createStatement();

        String sqlQuery = "SELECT * FROM public.library_history";
        ResultSet queryResult = null;
        try{
            queryResult = statement.executeQuery(sqlQuery);
        }catch (Exception e){
            e.printStackTrace();
        }
        while(queryResult.next()){
            returnList.add(new History(queryResult.getString(1),queryResult.getString(2),queryResult.getString(3)));
        }
        System.out.println();
        connection.close();
        return new HistoryList(returnList);
    }
}
