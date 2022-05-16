package main;

import entities.Member;
import entities.MemberList;
import ui.Ui;

import java.util.Scanner;

public class Engine {
  private Scanner sc = new Scanner(System.in);
  public static MemberList memberList = new MemberList();
  private Sort sort = new Sort();
  private int memberId = 1;
  private int idCode = 1000;
  private Ui ui = new Ui();

  public void runProgram() throws InterruptedException {
    boolean run = true;
    ui.dolphinLogo();
    ui.loadingBar();
    ui.introLabel();
    while (run) {
      ui.mainMenu();
      String choice = sc.nextLine();
      switch (choice) {
        case "1" -> addMember();
        case "2" -> System.out.println(memberList.toString());
        case "3" -> sortMemberList();
        case "4" -> deleteMember();
        case "5" -> changePaymentStatus();
        case "6" -> System.out.println("Implement see list of junior/senior members");
        case "7" -> System.out.println("Implement see list of active/non active members");
        case "8" -> System.out.println("Implement see list of payment status of members (paid/not paid)");
        case "9" -> System.out.println("Implement register best TRAINING result, date for junior/senior swimmers");
        case "10" -> System.out.println("Implement register best COMPETITION result, date for junior/senior swimmers ");
        case "11" -> System.out.println("Implement see list of top 5 results based on TRAINING results");
        case "12" -> System.out.println("Implement change status of swimmers from competition to free-timer swimmer (and vice versa)");
        case "99" -> {
          run = false;
          ui.newLine();
          System.out.println("SHUTTING DOWN");
        }
        default -> ui.invalidInput();
      }
    }

  }

  public void deleteMember() throws InterruptedException {
    System.out.println("Skriv medlemsnummeret på brugeren du ønsker at slette.");
    int whichMemberID = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < memberList.getMemberList().size(); i++) {
      Member member = memberList.getMemberList().get(i);
      if (whichMemberID == member.getId()) {
        System.out.println("Du ved at slette bruger: " + member.getFirstName() + " " + member.getSurname() + ", Medlemsnummer: " + member.getId());
        System.out.println("Tryk 1 for at slette tryk på alt andet for a afbryde.");
      } else if (whichMemberID != member.getId()) {
        ui.invalidInput();
        break;
      }
      String choice = sc.nextLine();
      if ("1".equals(choice)) {
        memberList.getMemberList().remove(i);
        System.out.println(member.getFirstName() + " " + member.getSurname() + " er blevet slettet.");
      } else break;
    }
  }

  public void sortMemberList() throws InterruptedException {
    ui.sortMenu();
    switch (sc.nextLine()) {
      case "1" -> sort.sortSurname();
      case "2" -> sort.sortFirstname();
      case "3" -> sort.sortAge();
      case "4" -> sort.sortActive(); //Not working yet
      case "5" -> sort.sortComp(); //Not working yet
      case "6" -> sort.sortRegDate();
      case "7" -> sort.sortId();
      default -> ui.invalidInput();
    }
  }

  public void addMember() {
    ui.newLine();
    System.out.println("Du er nu i gang med at Tilføje et nyt medlem!\n\n\n");
    System.out.println("Indtast medlemmets fornavn:");
    String firstname = sc.nextLine();
    System.out.println("Indtast medlemmets efternavn");
    String surname = sc.nextLine();
    System.out.println("\n\nIndtast medlemmets fødselsdagsdato. (FORMAT DD/MM/YEAR):");
    Birthday birthday = new Birthday();
    birthday.checkBirthday();
    System.out.println("\n\nIndtast om medlemmet er aktiv eller inaktiv");
    boolean memberStatus = makeChoiceBoolean(ui.activePassiveChoice());
    System.out.println("\n\nIndtast om medlemmet er konkurrencesvømmer eller motionssvømmer");
    boolean competitionStatus = makeChoiceBoolean(ui.compNonCompChoice());
    System.out.println("\n\nIndtast om medlemmet har betalt eller ikke betalt");
    boolean paymentStatus = makeChoiceBoolean(ui.paidNotPaidChoice());
    idCode = updateIdCode(idCode);
    Member member = new Member(birthday, memberId, firstname, surname, memberStatus, competitionStatus, paymentStatus, idCode);
    memberList.addMemberToList(member);
    memberId++;
  }

  public int updateIdCode(int idCode) {
    if (memberId == 1000) {
      memberId = 1001;
      return 10000;
    } else if (memberId == 9999) {
      return 100000;
    } else return idCode;
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

  public void changePaymentStatus() {
    System.out.println("Indtast ID på medlem, som du vil ændre betalingsstatus for:");
    int id = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < memberList.getMemberList().size(); i++) {
      if (id == memberList.getMemberList().get(i).getId()) {
        boolean run = true;
        while (run) {
          System.out.println("Hvilken betalingsstatus skal medlemmet have?");
          System.out.println("1: Betalt");
          System.out.println("2: Ikke betalt");
          String input = sc.nextLine();
          switch (input) {
            case "1" -> {
              memberList.getMemberList().get(i).setPayment(true);
              run = false;
            }
            case "2" -> {
              memberList.getMemberList().get(i).setPayment(false);
              run = false;
            }
            default -> System.out.println("Invalid input");
          }
        }
      }
    }
  }
  
}