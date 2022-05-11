package com.company;

import java.util.Scanner;

public class Engine {
  Scanner sc = new Scanner(System.in);
  MemberList memberList = new MemberList();
  private int memberId = 2022001;
  Ui ui = new Ui();

  public void runProgram() throws InterruptedException {
    boolean run = true;
    ui.introLabel();
    while (run) {
      ui.mainMenu();
      String choice = sc.nextLine();
      switch (choice) {
        case "1" -> addMember();
        case "2" -> System.out.println(memberList.toString());
        case "9" -> {
          run = false;
          ui.newLine();
          System.out.println("SHUTTING DOWN");
        }
        default -> ui.invalidInput();
      }
    }

  }

  public void addMember() {
    ui.newLine();
    System.out.println("Du er nu i gang med at Tiljøje et nyt medlem!\n\n\n");
    System.out.println("Indtast medlemmets navn:");
    String name = sc.nextLine();
    System.out.println("\n\nIndtast medlemmets alder:");
    int age = sc.nextInt();
    sc.nextLine();
    System.out.println("\n\nIndtast om medlemmet er aktiv eller inaktiv");
    boolean memberStatus = makeChoiceBoolean("Aktiv = 1\nInactiv = 2");
    System.out.println("\n\nIndtast om medlemmet er konkurrencesvømmer eller motionssvømmer");
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
}