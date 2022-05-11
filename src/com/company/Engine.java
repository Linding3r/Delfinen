package com.company;

import java.util.Scanner;

public class Engine {
  Scanner sc = new Scanner(System.in);
  MemberList memberList = new MemberList();
  private int memberId = 2022001;

  public void runProgram() {
    boolean run = true;
    while (run) {
      System.out.println("Velkommen til Delfin-klubbens medlemssystem.");
      System.out.println("Du kan vælge at tilføje medlemmer til medlemslisten");
      System.out.println("1: Tilføj medlem");
      String choice = sc.nextLine();
      switch (choice) {
        case "1" -> addMember();
        case "2" -> System.out.println(memberList.toString());
      }
    }

  }

  public void addMember() {
    System.out.println("Indtast medlemmets navn:");
    String name = sc.nextLine();
    System.out.println("Indtast medlemmets alder:");
    int age = sc.nextInt();
    sc.nextLine();
    System.out.println("Indtast om medlemmet er aktiv eller inaktiv");
    boolean memberStatus = makeChoiceBoolean("Aktiv = 1\nInactiv = 2");
    System.out.println("Indtast om medlemmet er konkurrencesvømmer eller motionssvømmer");
    boolean competitionStatus = makeChoiceBoolean("Konkurrencesvømmer = 1\nMotionssvømmer = 2");
    Member member = new Member(age, memberId, name, memberStatus, competitionStatus);
    memberList.addMemberToList(member);
    memberId++;
  }

  public boolean makeChoiceBoolean(String ui) {
    boolean value = true;
    boolean run = true;
    while (run) {
      System.out.println(ui);
      String input = sc.nextLine();
      switch (input) {
        case "1" -> {
          value = true;
          run = false;
        }
        case "2" -> {
          value = false;
          run = false;
        }
        default -> System.out.println("Forkert input");
      }
    }
    return value;
  }






























/*

  public void execute() {
    gui.chooseUser();
  }

  public void presidentExecute(){
    gui.mainPanelPresident();
    System.out.println("Welcome to the President menu!!");
  }

  public void cashierExecute(){
//    gui.mainPanelCashier();
    System.out.println("Welcome to the Cashier menu!");
  }

  public void trainerExecute(){
//    gui.mainPanelTrainer();
    System.out.println("Welcome to the Trainer menu!");
  }*/
}