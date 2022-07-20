package Utilities;

import Utilities.Utils;

import jdk.jshell.execution.Util;

public class BorrowThread extends Thread{
    public String name;

    BorrowThread(String name ){
        this.name = name;
    }


    @Override
    public void run() {

        while (!Utils.borrowMethod(this.name)){

            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
            }
        }
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        try {
            Utils.returnMethod(this.name);
        } catch (Exception e) {
        }
    }

}