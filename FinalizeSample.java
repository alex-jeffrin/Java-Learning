class createUser {

    createUser(){
        System.out.println("New user is created");
        String user_name = "user name ";
        int user_id = 12;

    }

    protected void finalize(){

        System.out.println("The user account is unlinked and deleted");

    }

}

class FinalizeSample {
    public static void main (String args[]){
        createUser user1 = new createUser();
        createUser user2 = new createUser(); //There are two users created
        
        new createUser();

        user1 = null;

        System.gc(); // the user1 is deleted cause its value is null so it no more exists

    }
}