package main;

import disciplins.SwimmingTime;
import entities.Member;
import entities.MemberList;
import entities.Trainer;
import ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Engine {
  private Scanner sc = new Scanner(System.in);
  public static MemberList memberList = new MemberList();
  private Sort sort = new Sort();
  private int memberId = 1;
  private int idCode = 1000;
  private Ui ui = new Ui();
  private SwimmingTime swimmingTime = new SwimmingTime();

  public void runProgram() throws InterruptedException, FileNotFoundException {
    boolean run = true;
    ui.dolphinLogo();
    ui.loadingBar();
    loadMembersFromFile();
    ui.introLabel();
    while (run) {
      ui.mainMenu();
      String choice = sc.nextLine();
      switch (choice) {
        case "1" -> addMember();
        case "2" -> System.out.println(memberList.toString());
        case "3" -> sortMemberList();
        case "4" -> updateMember(C = Choice.ONE);
        case "5" -> updateMember(C = Choice.TWO);
        case "6" -> updateMember(C = Choice.THREE);
        case "7" -> checkIncome();
        case "8" -> addOrRemoveTrainer();
        //case "8" -> System.out.println("Implement register best COMPETITION/Training result, date for junior/senior swimmers ");
        //case "9" -> System.out.println("Implement see list of top 5 results in each disciplin");
        //case "8" -> System.out.println("Implement change status of swimmers from competition to free-timer swimmer (and vice versa)");
        case "0" -> {
          run = false;
          ui.newLine();
          System.out.println("SHUTTING DOWN");
        }
        default -> ui.invalidInput();
      }
    }

  }
  private void updateMember(Choice c) throws InterruptedException {
    System.out.println("Indtast ID på medlem:");
    try {
      int id = sc.nextInt();
      sc.nextLine();
      for (int i = 0; i < memberList.getMemberList().size(); i++) {
        if (id == memberList.getMemberList().get(i).getId()) {
          System.out.println("De nuværende oplysninger på medlemmet er:");
          System.out.println(memberList.getMemberList().get(i));
          switch (c) {
            case ONE -> deleteMember(i);
            case TWO -> changePaymentStatusLoop(i);
            case THREE -> changeMemberStatus(i);
          }
        }
      }
    } catch (NumberFormatException | InputMismatchException exception) {
      ui.invalidInput();
    }
  }

  private void chooseTrainer(int i) throws InterruptedException {
    boolean run = true;
    while (run) {
      run = false;
      System.out.println(ui.chooseTrainer());
      String input = sc.nextLine();
      switch (input) {
        case "1" -> memberList.getMemberList().get(i).setTrainer(trainer1);
        case "2" -> memberList.getMemberList().get(i).setTrainer(trainer2);
        default -> {
          System.out.println("Invalid input");
          run = true;
        }
      }
    }
  }

//  public Member searchMember() throws InterruptedException { //TODO: Add searchMember method to all method that use this function
//    System.out.println("Indtast ID på medlem:");
//    try {
//      int id = sc.nextInt();
//      sc.nextLine();
//      for (int i = 0; i < memberList.getMemberList().size(); i++) {
//        if (id == memberList.getMemberList().get(i).getId()) {
//          return memberList.getMemberList().get(i);
//        }
//      }
//    } catch (NumberFormatException | InputMismatchException exception) {
//      ui.invalidInput();
//    } return null;
//  }



  private void addOrRemoveTrainer() throws InterruptedException {
    System.out.println("Indtast ID på medlem:");
    try {
      int id = sc.nextInt();
      sc.nextLine();
      for (int i = 0; i < memberList.getMemberList().size(); i++) {
        if (id == memberList.getMemberList().get(i).getId()) {
          boolean run = true;
          while (run) {
            run = false;
            System.out.println(ui.removeOrAddTrainer());
            String input = sc.nextLine();
            switch (input) {
              case "1" -> chooseTrainer(i);
              case "2" -> memberList.getMemberList().get(i).setTrainer(null);
              default -> {
                ui.invalidInput();
                run = true;
              }
            }
          }
        }
      }
    } catch (NumberFormatException | InputMismatchException exception) {
      ui.invalidInput();
    }
  }

  private void checkIncome() {
    int income = 0;
    for (int i = 0; i < memberList.getMemberList().size(); i++) {
      income += memberList.getMemberList().get(i).subscription();
    }
    System.out.println("\n\n\nForventet årligt indkomst:");
    System.out.println(income + "DKK");
  }

  public void deleteMember(int i) {
    Member member = memberList.getMemberList().get(i);
    System.out.println("Du ved at slette bruger: " + member.getFirstName() + " " + member.getSurname() + ", Medlemsnummer: " + member.getId());
    System.out.println("Tryk 1 for at slette tryk på alt andet for at afbryde.");
    String choice = sc.nextLine();
    if (Objects.equals(choice, "1")) {
      memberList.getMemberList().remove(i);
      System.out.println(member.getFirstName() + " " + member.getSurname() + " er blevet slettet.");
    }
  }

  public void sortMemberList() throws InterruptedException {
    boolean run = true;
    while (run) {
      run = false;
      ui.sortMenu();
      switch (sc.nextLine()) {
        case "1" -> sort.sortSurname();
        case "2" -> sort.sortFirstname();
        case "3" -> sort.sortAge();
        case "4" -> sort.sortActive();
        case "5" -> sort.sortComp();
        case "6" -> sort.sortRegDate();
        case "7" -> sort.sortId();
        case "8" -> sort.sortPayment();
        case "9" -> System.out.println("Tilbage");
        default -> {
          ui.invalidInput();
          run = true;
        }
      }
    }
    System.out.println(memberList.toString());
  }

  public void addMember() {
    ui.newLine();
    System.out.println("Du er nu i gang med at Tilføje et nyt medlem!\n\n\n");
    System.out.println("Indtast medlemmets fornavn:");
    String firstname = sc.nextLine();
    System.out.println("Indtast medlemmets efternavn");
    String surname = sc.nextLine();
    System.out.println("\n\nIndtast medlemmets fødselsdagsdato. (FORMAT DD/MM/YEAR):");
    Date date = new Date();
    date.createDate();
    System.out.println("\n\nIndtast om medlemmet er konkurrencesvømmer eller motionssvømmer");
    boolean competitionStatus = makeChoiceBoolean(ui.compNonCompChoice());
    idCode = updateIdCode(idCode);
    Member member = new Member(date, memberId, firstname, surname, competitionStatus, idCode);
    ui.confirmInput();
    System.out.println(member);
    boolean yesNo = makeChoiceBoolean(ui.yesNo());
    if (yesNo == true) {
      memberList.addMemberToList(member);
      memberId++;
    }
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
      run = false;
      System.out.println(ui);
      String input = sc.nextLine();
      switch (input) {
        case "1" -> value = true;
        case "2" -> value = false;
        default -> {
          System.out.println("INVALID INPUT");
          run = true;
        }
      }
    }
    return value;
  }

  public void loadLastMemberID() {
    int memberYear = memberList.getMemberList().get(memberList.getMemberList().size() - 1).getRegisterDate().getYear();
    memberId = (memberList.getMemberList().get(memberList.getMemberList().size() - 1).getId() - (memberYear * idCode)) + 1;
  }

  public void loadMembersFromFile() {
    try {
      Scanner fileScanner = new Scanner(new File("members.csv"));
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        Scanner input = new Scanner(line).useDelimiter(";").useLocale(Locale.ENGLISH);
        Date birthday = new Date();
        int iD = input.nextInt();
        String surname = input.next();
        String firstName = input.next();
        boolean competition = input.nextBoolean();
        birthday.setBirthday(input.next());
        birthday.checkDateFromCSV();
        birthday.birthdayToAge();
        int age = birthday.getAge();
        Member member = new Member(birthday, age, iD, firstName, surname, competition);
        memberList.addMemberToList(member);
      }
      } catch (FileNotFoundException e) {
        System.out.println("Cannot locate file");
      } try {
      sort.sortId();
      loadLastMemberID();
    } catch (NoSuchElementException | IndexOutOfBoundsException e) {
        System.out.println("File is empty\n\n\n");
      }
    }

  public void saveAnimalsToFile() {
    try {
      PrintStream out = new PrintStream("members.csv");
      for (int i = 0; i < memberList.getMemberList().size(); i++) {
        Member member = memberList.getMemberList().get(i);
        out.print(member.getId());
        out.print(";");
        out.print(member.getSurname());
        out.print(";");
        out.print(member.getFirstName());
        out.print(";");
        out.print(member.isCompetitionSwimmer());
        out.print(";");
        out.print(member.getBirthday());
        out.print(";");
        out.print(member.getAge());
        out.print(";\n");


      }
    } catch (FileNotFoundException e) {
      System.out.println("Cannot locate file");
    }
  }


  public void changePaymentStatusLoop(int i) {
    boolean run = true;
    while (run) {
      System.out.println(ui.paidNotPaidChoice());
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

  public void changeMemberStatus(int i) throws InterruptedException {
    boolean run = true;
    while (run) {
      System.out.println(ui.activePassiveChoice());
      String input = sc.nextLine();
      switch (input) {
        case "1" -> {
          memberList.getMemberList().get(i).setActive(true);
          run = false;
        }
        case "2" -> {
          memberList.getMemberList().get(i).setActive(false);
          run = false;
        }
        default -> System.out.println("Invalid input");
      }
    }

  }

}