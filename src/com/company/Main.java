package com.company;


public class Main {

    public void run (){

        Member thomas = new Member(95,007,"Thomas Lindinger", false, false);

        System.out.println(thomas);
    }

    public static void main(String[] args) {

        new Main().run();
        //Engine engine = new Engine();
        //engine.execute();
    }


}
