package com.company;

import javax.swing.*;


public class Engine {
  SwingGUI gui = new SwingGUI();


  public void execute() {
    gui.chooseUser();
  }

  public void presidentExecute(JFrame frame){
    frame.setVisible(false);
    gui.mainPanelPresident();
    System.out.println("Welcome to the President menu!!");
  }

  public void cashierExecute(JFrame frame){
    frame.setVisible(false);
    gui.mainPanelCashier();
    System.out.println("Welcome to the Cashier menu!");
  }

  public void trainerExecute(JFrame frame){
    frame.setVisible(false);
    gui.mainPanelTrainer();
    System.out.println("Welcome to the Trainer menu!");
  }
}