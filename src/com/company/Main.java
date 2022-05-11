package com.company;


import javax.swing.*;

public class Main {

    public void run (){

        Medlem thomas = new Medlem(95,007,"Thomas Lindinger", false, false);

        System.out.println(thomas);
    }

    public static void main(String[] args) {

        new Main().run();
        //Engine engine = new Engine();
        //engine.execute();
    }


}
