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

        while (!Utils.borrowmethod(this.name)){

                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            Utils.returnmethod(this.name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}