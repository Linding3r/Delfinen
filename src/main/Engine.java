package main;

import disciplins.SwimmingStyle;
import disciplins.SwimmingTime;
import disciplins.Time;
import entities.Member;
import entities.MemberList;
import entities.Trainer;
import ui.SwingGUI;
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
  private Trainer trainer1 = new Trainer("Egon Olson");
  private Trainer trainer2 = new Trainer("Benny Frandsen");

  public void runProgram() throws FileNotFoundException, InterruptedException {
    System.out.println(ui.consoleOrSwing());
    loadMembersFromFile();
    String choice = sc.nextLine();
    switch (choice) {
      case "1" -> runConsole();
      case "2" -> runSwing();
      default -> ui.invalidInput();
    }
  }

  public void runSwing(){
    SwingGUI swing = new SwingGUI();
    swing.mainMenu();
  }

  public void runConsole() throws InterruptedException, FileNotFoundException {
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
        case "5" -> changePaymentStatusLoop();
        case "6" -> changeMemberStatus();
        case "7" -> checkIncome();
        case "8" -> addOrRemoveTrainer();
        case "9" -> createTime();
        //case "8" -> System.out.println("Implement register best COMPETITION/Training result, date for junior/senior swimmers ");
        //case "9" -> System.out.println("Implement see list of top 5 results in each disciplin");
        //case "8" -> System.out.println("Implement change status of swimmers from competition to free-timer swimmer (and vice versa)");
        case "0" -> {
          run = false;
          ui.newLine();
          System.out.println("SHUTTING DOWN");
          saveMemberToFile();
        }
        default -> ui.invalidInput();
      }
    }

  }

  private void createTime() throws InterruptedException {
    Date date = new Date();
    Time time = new Time();
    System.out.println("Indtast ID på medlem:");
    int indexPosition = searchMember();
    Member member = memberList.getMemberList().get(indexPosition);
    System.out.println("Hvilken dato er tiden sat?");
    date.createDate();
    swimmingTime.setDate(date);
    System.out.println("Hvilken svømmestil er tiden sat i?");
    System.out.println(ui.swimmingStyle());
    String validChoice = checkSwimmingStyleInput();
    System.out.println("Hvad er tiden?");
    time.competitionTime();
    boolean checkedTime = isExistingTime(time, indexPosition);
    if (checkedTime == true) {
      member.setFastestSwimmingTime(time);
      switch (validChoice) {
        case "1" -> member.getSwimmingTime().getSwimmingStyle().setButterfly(time);
        case "2" -> member.getSwimmingTime().getSwimmingStyle().setCrawl(time);
        case "3" -> member.getSwimmingTime().getSwimmingStyle().setBackcrawl(time);
        case "4" -> member.getSwimmingTime().getSwimmingStyle().setBreaststroke(time);
        }
      }
      // TODO: 18/05/2022 Implement ask for competition/not competition
    }

  private void updateSwimmingTime() {
    // TODO: 18/05/2022 Implement
  }

  private boolean isExistingTime(Time time, int indexPosition) {
    Member member = memberList.getMemberList().get(indexPosition);
    if (member.getFastestSwimmingTime() != null) {
      return isTimeFaster(time,member);
    } else return true;
  }

  private boolean isTimeFaster(Time time, Member member) {
    if (time.getMinutes() < member.getFastestSwimmingTime().getMinutes()) {
      return true;
    } else if (time.getMinutes() == member.getFastestSwimmingTime().getMinutes()) {
      if (time.getSeconds() < member.getFastestSwimmingTime().getSeconds()) {
        return true;
      } else if (time.getSeconds() == member.getFastestSwimmingTime().getSeconds()) {
        if (time.getMiliseconds() < member.getFastestSwimmingTime().getMiliseconds()) {
          return true;
        }
      }
    }
    return false;
  }

  private String checkSwimmingStyleInput() throws InterruptedException {
    boolean runLoop = true;
    String choice = "";
    while (runLoop) {
      choice = sc.nextLine();
      switch (choice) {
        case "1", "2", "3", "4" -> runLoop = false;
        default -> ui.invalidInput();
      }
    }
     return choice;
  }
  private int searchMember() throws InterruptedException {
    System.out.println("Indtast ID på medlem:");
    int id = sc.nextInt();
    sc.nextLine();
    try {
      for (int i = 0; i < memberList.getMemberList().size(); i++) {
        if (id == memberList.getMemberList().get(i).getId()) {
          System.out.println("De nuværende oplysninger på medlemmet er:");
          System.out.println(memberList.getMemberList().get(i));
          return i;
          }
        }
      } catch (NumberFormatException | InputMismatchException exception) {
      ui.invalidInput();
    } return 0;
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

  public void deleteMember() throws InterruptedException {
    int i = searchMember();
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
        boolean payment = input.nextBoolean();
        birthday.setBirthday(input.next());
        birthday.checkDateFromCSV();
        birthday.birthdayToAge();
        int age = birthday.getAge();
        Member member = new Member(birthday, age, iD, firstName, surname, competition, payment);
        memberList.addMemberToList(member);
      }
      } catch (FileNotFoundException | NoSuchElementException e) {
        System.out.println("Cannot locate file");
      } try {
      sort.sortId();
      loadLastMemberID();
    } catch (NoSuchElementException | IndexOutOfBoundsException e) {
        System.out.println("File is empty\n\n\n");
      }
    }

  public void saveMemberToFile() {
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
        out.print(member.isPayment());
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


  public void changePaymentStatusLoop() throws InterruptedException {
    int i = searchMember();
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

  public void changeMemberStatus() throws InterruptedException {
    int i = searchMember();
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