package main;

import entities.Member;
import entities.MemberList;
import ui.Ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Engine {
  private Scanner sc = new Scanner(System.in);
  public static MemberList memberList = new MemberList();
  private Sort sort = new Sort();

  private int memberId = 2022001;
  Ui ui = new Ui();

  public void runProgram() throws InterruptedException {
    boolean run = true;
    ui.dolphinLogo();
    ui.introLabel();
    while (run) {
      ui.mainMenu();
      String choice = sc.nextLine();
      switch (choice) {
        case "1" -> addMember();
        case "2" -> System.out.println(memberList.toString());
        case "3" -> sortMemberList();
        case "9" -> {
          run = false;
          ui.newLine();
          System.out.println("SHUTTING DOWN");
        }
        default -> ui.invalidInput();
      }
    }

  }

  public void sortMemberList() throws InterruptedException {
    ui.sortMenu();
    switch(sc.nextLine()){
      case "1" -> sort.sortSurname();
      case "2" -> sort.sortFirstname();
      case "3" -> sort.sortAge();
      case "4" -> sort.sortActive(); //Not working yet
      case "5" -> sort.sortComp(); //Not working yet
      case "6" -> sort.sortRegDate();
      default -> ui.invalidInput();
    }
  }

  public void addMember() {
    ui.newLine();
    System.out.println("Du er nu i gang med at Tiljøje et nyt medlem!\n\n\n");
    System.out.println("Indtast medlemmets fornavn:");
    String firstname = sc.nextLine();
    System.out.println("Indtast medlemmets efternavn");
    String surname = sc.nextLine();
    System.out.println("\n\nIndtast medlemmets alder:");
    int age = sc.nextInt();
    sc.nextLine();
    System.out.println("\n\nIndtast om medlemmet er aktiv eller inaktiv");
    boolean memberStatus = makeChoiceBoolean(ui.activePassiveChoice());
    System.out.println("\n\nIndtast om medlemmet er konkurrencesvømmer eller motionssvømmer");
    boolean competitionStatus = makeChoiceBoolean(ui.compNonCompChoice());
    Member member = new Member(age, memberId, firstname, surname, memberStatus, competitionStatus);
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
        default -> System.out.println("INVALID INPUT");
      }
    }
    return value;
  }
}