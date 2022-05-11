package com.company;



public class Engine {

  private int memberId = 2022001;

  public int getMemberId() {
    return memberId;
  }

  public void setMemberId(int memberId) {
    this.memberId = memberId;
  }

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