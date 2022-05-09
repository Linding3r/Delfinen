package com.company;

import javax.swing.*;


public class Engine {



  public void execute() {
    SwingGUI gui = new SwingGUI();
    gui.chooseUser();
  }

  public void presidentExecute(JFrame visibility){
    visibility.setVisible(false);
    System.out.println("Welcome to the President menu!!");
  }

  public void cashierExecute(JFrame visibility){
    visibility.setVisible(false);
    System.out.println("Welcome to the Cashier menu!");
  }

  public void trainerExecute(JFrame visibility){
    visibility.setVisible(false);
    System.out.println("Welcome to the Trainer menu!");
  }

}
