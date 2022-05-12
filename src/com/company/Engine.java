package com.company;



public class Engine {


  SwingGUI gui = new SwingGUI();

  public void execute() {
    gui.chooseUser();
  }

  public void presidentExecute(){
    gui.mainPanelPresident();
  }

  public void cashierExecute(){
//    gui.mainPanelCashier();
  }

  public void trainerExecute(){
//    gui.mainPanelTrainer();
  }
}