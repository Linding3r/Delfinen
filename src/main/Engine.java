package main;

import disciplins.Competition;
import disciplins.SwimmingStyle;
import disciplins.SwimmingTime;
import disciplins.Time;
import entities.AgeGroup;
import entities.Member;
import entities.Trainer;
import sorting.Sort;
import sorting.SortSwimmingTime;
import ui.SwingGUI;
import ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.Year;
import java.util.*;

public class Engine {
  private Scanner sc = new Scanner(System.in);
  private ArrayList<Member> memberList = new ArrayList<>();
  private Sort sort = new Sort();
  private int memberId = 1;
  private int idCode = 1000;
  private Ui ui = new Ui();
  private Trainer trainer1 = new Trainer("Egon");
  private Trainer trainer2 = new Trainer("Benny");
  private ArrayList<Competition> competitionsList = new ArrayList<>();

  public void runProgram() throws FileNotFoundException, InterruptedException {
    System.out.println(ui.consoleOrSwing());
    loadMembersFromFile();
    loadCompetitionsFromFile();
    String choice = sc.nextLine();
    boolean runLoop = true;
    while (runLoop) {
      switch (choice) {
        case "1" -> {
          runConsole();
          runLoop = false;
        }
         case "2" -> {
        runSwing();
        runLoop = false;
        }
        default -> ui.invalidInput();
      }
    }
  }

  public void runSwing() {
    SwingGUI swing = new SwingGUI();
    swing.mainMenu();
  }

  public void runConsole() throws InterruptedException {
    boolean run = true;
    ui.dolphinLogo();
    ui.loadingBar();
    ui.introLabel();
    while (run) {
      ui.mainMenu();
      String choice = sc.nextLine();
      switch (choice) {
        case "1" -> addMember();
        case "2" -> System.out.println(ui.memberListToString(memberList));
        case "3" -> sortMemberList();
        case "4" -> deleteMember();
        case "5" -> changePaymentStatusLoop();
        case "6" -> changeMemberStatus();
        case "7" -> changeActivityStatus();
        case "8" -> checkIncome();
        case "9" -> addOrRemoveTrainer();
        case "10" -> createTime();
        case "11" -> viewTop5();
        case "12" -> System.out.println(ui.competitionListToString(competitionsList));
        case "0" -> {
          run = false;
          ui.newLine();
          System.out.println("SHUTTING DOWN");
          saveMemberToFile();
          saveCompetitionsToFile();
        }
        default -> ui.invalidInput();
      }
    }
  }

  private void changeActivityStatus() throws InterruptedException {
    int i = searchMember();
    boolean run = true;
    while (run) {
      System.out.println("Hvad skal medlemmets status ??ndres til?");
      System.out.println(ui.compNonCompChoice());
      String input = sc.nextLine();
      switch (input) {
        case "1" -> {
          memberList.get(i).setCompetitionSwimmer(true);
          run = false;
        }
        case "2" -> {
          memberList.get(i).setCompetitionSwimmer(false);
          run = false;
        }
        default -> System.out.println("Invalid input");
      }
    }
    
  }

  private void viewTop5() throws InterruptedException {
    System.out.println(ui.swimmingStyle());
    String choiceSwimmingStyle = checkSwimmingStyleInput();
    System.out.println(ui.juniorOrSenior());
    String choiceAgeGroup = checkAgeGroup();
    if (choiceAgeGroup.equals("1")) {
      switch (choiceSwimmingStyle) {
        case "1" -> sortByStyle(memberList, AgeGroup.JUNIOR, SwimmingStyle.BUTTERFLY);
        case "2" -> sortByStyle(memberList, AgeGroup.JUNIOR, SwimmingStyle.CRAWL);
        case "3" -> sortByStyle(memberList, AgeGroup.JUNIOR, SwimmingStyle.BACKCRAWL);
        case "4" -> sortByStyle(memberList, AgeGroup.JUNIOR, SwimmingStyle.BREASTSTROKE);
      }
    } else
      switch (choiceSwimmingStyle) {
        case "1" -> sortByStyle(memberList, AgeGroup.SENIOR, SwimmingStyle.BUTTERFLY);
        case "2" -> sortByStyle(memberList, AgeGroup.SENIOR, SwimmingStyle.CRAWL);
        case "3" -> sortByStyle(memberList, AgeGroup.SENIOR, SwimmingStyle.BACKCRAWL);
        case "4" -> sortByStyle(memberList, AgeGroup.SENIOR, SwimmingStyle.BREASTSTROKE);
      }
    }



  public void sortByStyle(ArrayList<Member> memberList, AgeGroup ageGroup, SwimmingStyle swimmingStyle) {
    ArrayList<Member> top5 = new ArrayList<>();
    for (int i = 0; i < memberList.size(); i++) {
      Member getMember = memberList.get(i);
      if (getMember.getFastestSwimmingTime().getTime().getTime() != null
          && getMember.getFastestSwimmingTime().getSwimmingStyle() == swimmingStyle
          && getMember.getAgeGroup() == ageGroup
          && getMember.isCompetitionSwimmer() == true) {
        top5.add(memberList.get(i));
      }
    }
    if (top5.size() != 0) {
      Collections.sort(top5, new SortSwimmingTime());
      for (int i = 0; i < 5; i++) {
        if (i < top5.size()) {
          System.out.println(top5.get(i));
        }
      }
    } else System.out.println("Der er ingen medlemmer p?? top 5 listen endnu for denne sv??mmedisciplin og aldersgruppe");
  }

  public void createTime() throws InterruptedException {
    Date date = new Date();
    Time time = new Time();
    int indexPosition = searchMember();
    Member member = memberList.get(indexPosition);
    int memberId = member.getId();
    System.out.println("Hvilken dato er tiden sat?");
    date.createDate();
    System.out.println("Hvilken sv??mmestil er tiden sat i?");
    System.out.println(ui.swimmingStyle());
    String validChoice = checkSwimmingStyleInput();
    System.out.println("Hvad er tiden?");
    time.competitionTime();
    SwimmingTime swimmingTime = new SwimmingTime(date, time);
    switch (validChoice) {
      case "1" -> swimmingTime.setSwimmingStyle(SwimmingStyle.BUTTERFLY);
      case "2" -> swimmingTime.setSwimmingStyle(SwimmingStyle.CRAWL);
      case "3" -> swimmingTime.setSwimmingStyle(SwimmingStyle.BACKCRAWL);
      case "4" -> swimmingTime.setSwimmingStyle(SwimmingStyle.BREASTSTROKE);
    }
    System.out.println("Blev tiden sat til en konkurrence?");
    System.out.println(ui.yesNo());
    boolean yesNoChoice = yesNo();
    if (yesNoChoice == true) {
      System.out.println("Indtast navn p?? konkurrencen");
      String competitionName = sc.nextLine();
      swimmingTime.setCompetitionName(competitionName);
      String position = inputPosition();
      swimmingTime.setPosition(position);
      Competition competition = new Competition(swimmingTime, competitionName, memberId, position);
      competitionsList.add(competition);
    }
    boolean checkedTime = isExistingTime(time, indexPosition);
    if (checkedTime == true) {
      member.setFastestSwimmingTime(swimmingTime);
    }
  }

  public String inputPosition(){
    String position = "";
    System.out.println("Hvilken position fik sv??mmeren?");
    position = sc.nextLine();
    return position;
  }

  public boolean yesNo() {
    boolean runLoop = true;
    boolean yesNo = false;
    while (runLoop) {
      String choice = sc.nextLine();
      switch (choice) {
        case "1" -> {
          yesNo = true;
          runLoop = false;
        }
        case "2" -> {
          runLoop = false;
        }
        default -> System.out.println("Invalid input");
      }
    }
    return yesNo;
  }

  public boolean isExistingTime(Time time, int indexPosition) {
    Member member = memberList.get(indexPosition);
    if (member.getFastestSwimmingTime().getTime().getTime() != null) {
      return isTimeFaster(time, member);
    } else return true;
  }

  public boolean isTimeFaster(Time time, Member member) {
    if (time.getMinutes() < member.getFastestSwimmingTime().getTime().getMinutes()) {
      return true;
    } else if (time.getMinutes() == member.getFastestSwimmingTime().getTime().getMinutes()) {
      if (time.getSeconds() < member.getFastestSwimmingTime().getTime().getSeconds()) {
        return true;
      } else if (time.getSeconds() == member.getFastestSwimmingTime().getTime().getSeconds()) {
        if (time.getMiliseconds() < member.getFastestSwimmingTime().getTime().getMiliseconds()) {
          return true;
        }
      }
    }
    return false;
  }

  public String checkSwimmingStyleInput() throws InterruptedException {
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

  public String checkAgeGroup() throws InterruptedException {
    boolean runLoop = true;
    String choice = "";
    while (runLoop) {
      choice = sc.nextLine();
      switch (choice) {
        case "1", "2" -> runLoop = false;
        default -> ui.invalidInput();
      }
    }
    return choice;
  }

  public int searchMember() throws InterruptedException {
    System.out.println("Indtast ID p?? medlem:");
    int id = sc.nextInt();
    sc.nextLine();
    try {
      for (int i = 0; i < memberList.size(); i++) {
        if (id == memberList.get(i).getId()) {
          System.out.println("De nuv??rende oplysninger p?? medlemmet er:");
          System.out.println(memberList.get(i));
          return i;
        }
      }
    } catch (NumberFormatException | InputMismatchException exception) {
      ui.invalidInput();
    }
    return 0;
  }

  public void chooseTrainer(int i) {
    boolean run = true;
    while (run) {
      run = false;
      System.out.println(ui.chooseTrainer());
      String input = sc.nextLine();
      switch (input) {
        case "1" -> memberList.get(i).setTrainer(trainer1);
        case "2" -> memberList.get(i).setTrainer(trainer2);
        default -> {
          System.out.println("Invalid input");
          run = true;
        }
      }
    }
  }


  public void addOrRemoveTrainer() throws InterruptedException {
    System.out.println("Indtast ID p?? medlem:");
    try {
      int id = sc.nextInt();
      sc.nextLine();
      for (int i = 0; i < memberList.size(); i++) {
        if (id == memberList.get(i).getId()) {
          boolean run = true;
          while (run) {
            run = false;
            System.out.println(ui.removeOrAddTrainer());
            String input = sc.nextLine();
            switch (input) {
              case "1" -> chooseTrainer(i);
              case "2" -> memberList.get(i).setTrainer(null);
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

  public int checkIncome() {
    int income = 0;
    for (int i = 0; i < memberList.size(); i++) {
      income += memberList.get(i).subscription();
    }
    System.out.println("\n\n\nForventet ??rligt indkomst:");
    System.out.println(income + "DKK");
    return income;
  }

  public void deleteMember() throws InterruptedException {
    int i = searchMember();
    Member member = memberList.get(i);
    System.out.println("Du ved at slette bruger: " + member.getFirstName() + " " + member.getSurname() + ", Medlemsnummer: " + member.getId());
    System.out.println("Tryk 1 for at slette tryk p?? alt andet for at afbryde.");
    String choice = sc.nextLine();
    if (Objects.equals(choice, "1")) {
      memberList.remove(i);
      System.out.println(member.getFirstName() + " " + member.getSurname() + " er blevet slettet.");
    }
  }

  public void sortMemberList() throws InterruptedException {
    boolean run = true;
    while (run) {
      run = false;
      ui.sortMenu();
      switch (sc.nextLine()) {
        case "1" -> sort.sortSurname(memberList);
        case "2" -> sort.sortFirstname(memberList);
        case "3" -> sort.sortAge(memberList);
        case "4" -> sort.sortActive(memberList);
        case "5" -> sort.sortComp(memberList);
        case "6" -> sort.sortRegDate(memberList);
        case "7" -> sort.sortId(memberList);
        case "8" -> sort.sortPayment(memberList);
        case "9" -> Collections.sort(memberList, new SortSwimmingTime());
        case "10" -> System.out.println("Tilbage");
        default -> {
          ui.invalidInput();
          run = true;
        }
      }
    }
    System.out.println(ui.memberListToString(memberList));
  }

  public void addMember() {
    ui.newLine();
    System.out.println("Du er nu i gang med at Tilf??je et nyt medlem!\n\n\n");
    System.out.println("Indtast medlemmets fornavn:");
    String firstname = sc.nextLine();
    System.out.println("Indtast medlemmets efternavn");
    String surname = sc.nextLine();
    System.out.println("\n\nIndtast medlemmets f??dselsdagsdato. (FORMAT DD/MM/YEAR):");
    Date birthday = new Date();
    birthday.createDate();
    boolean competitionStatus = false;
    if (Integer.parseInt(String.valueOf(Year.now())) - birthday.getYear() < 60) {
      System.out.println("\n\nIndtast om medlemmet er konkurrencesv??mmer eller motionssv??mmer");
      competitionStatus = makeChoiceBoolean(ui.compNonCompChoice());
    }
    idCode = updateIdCode(idCode);
    Member member = new Member(birthday, memberId, firstname, surname, competitionStatus, idCode);
    ui.confirmInput();
    System.out.println(member);
    boolean yesNo = makeChoiceBoolean(ui.yesNo());
    if (yesNo == true) {
      memberList.add(member);
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
    int memberYear = memberList.get(memberList.size() - 1).getRegisterDate().getYear();
    memberId = (memberList.get(memberList.size() - 1).getId() - (memberYear * idCode)) + 1;
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
        birthday.setDate(input.next());
        birthday.checkDateFromCSV();
        birthday.birthdayToAge();
        int age = input.nextInt();
        Time time = new Time();
        Date swimDate = new Date();
        Trainer trainer = checkTrainerFromCSV(input.next());;
        SwimmingTime swimmingTime;
        if (time.competitionTimeCsv(input.next())) {
          SwimmingStyle style = SwimmingStyle.valueOf(input.next());
          swimDate.setDate(input.next());
          swimDate.checkDateFromCSV();
          swimmingTime = new SwimmingTime(swimDate, time);
          swimmingTime.setSwimmingStyle(style);
          Member member = new Member(birthday, age, iD, firstName, surname, competition, payment, swimmingTime, trainer);
          memberList.add(member);
        } else {
          Member member = new Member(birthday, age, iD, firstName, surname, competition, payment,trainer);
          memberList.add(member);
        }
      }
    } catch (FileNotFoundException | NoSuchElementException e) {
      System.out.println("Cannot locate file");
    }
    try {
      sort.sortId(memberList);
      loadLastMemberID();
    } catch (NoSuchElementException | IndexOutOfBoundsException e) {
      System.out.println("File is empty\n\n\n");
    }
  }

  public Trainer checkTrainerFromCSV(String name){
    if(name.equals("Egon")){
      return trainer1;
    } else if(name.equals("Benny")){
      return trainer2;
    } else return null;
  }

  public void saveMemberToFile() {
    try {
      PrintStream out = new PrintStream("members.csv");
      for (int i = 0; i < memberList.size(); i++) {
        Member member = memberList.get(i);
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
        out.print(";");
        try{
          out.print(member.getTrainer().getName());
        } catch (NullPointerException e) {
          out.print("");
        }
        out.print(";");
        try {
          out.print(member.getFastestSwimmingTime().getTime().getTime());
        } catch (NullPointerException e) {
          out.print("");
        }
        out.print(";");
        try {
          out.print(member.getFastestSwimmingTime().getSwimmingStyle());
        } catch (NullPointerException e) {
          out.print("");
        }
        out.print(";");
        try {
          out.print(member.getFastestSwimmingTime().getDate().getDate());
        } catch (NullPointerException e) {
          out.print("");
        }
        out.print("\n");


      }
    } catch (FileNotFoundException e) {
      System.out.println("Cannot locate file");
    }
  }

  public void saveCompetitionsToFile (){
    try {
      PrintStream out = new PrintStream("competitions.csv");
      for (int i = 0; i < competitionsList.size(); i++) {
        Competition comp = competitionsList.get(i);
        out.print(comp.getCompetitionName());
        out.print(";");
        out.print(comp.getSwimmingTime().getDate().getDate());
        out.print(";");
        out.print(comp.getMemberId());
        out.print(";");
        out.print(comp.getSwimmingTime().getSwimmingStyle());
        out.print(";");
        out.print(comp.getPlacement());
        out.print(";");
        out.print(comp.getSwimmingTime().getTime().getTime());
        out.print(";\n");
      }
    } catch (FileNotFoundException e) {
      System.out.println("Cannot locate file");
    }
  }

  public void loadCompetitionsFromFile() {
    try {
      Scanner fileScanner = new Scanner(new File("competitions.csv"));
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        Scanner input = new Scanner(line).useDelimiter(";").useLocale(Locale.ENGLISH);
        String compName = input.next();
        Date date = new Date();
        date.setDate(input.next());
        date.checkDateFromCSV();
        int memberId = input.nextInt();
        SwimmingStyle style = SwimmingStyle.valueOf(input.next());
        String placement = input.next();
        Time time = new Time();
        time.competitionTimeCsv(input.next());
        SwimmingTime swimmingTime = new SwimmingTime(date, time);
        swimmingTime.setSwimmingStyle(style);
        Competition competition = new Competition(swimmingTime, compName, memberId, placement);
        competitionsList.add(competition);
      }

    } catch (FileNotFoundException | NoSuchElementException e) {
      System.out.println("Cannot locate competition file");
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
          memberList.get(i).setPayment(true);
          run = false;
        }
        case "2" -> {
          memberList.get(i).setPayment(false);
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
          memberList.get(i).setActive(true);
          run = false;
        }
        case "2" -> {
          memberList.get(i).setActive(false);
          run = false;
        }
        default -> System.out.println("Invalid input");
      }
    }
  }

  public void setMemberList(ArrayList<Member> memberList) {
    this.memberList = memberList;
  }

  public ArrayList<Member> getMemberList() {
    return memberList;
  }
}