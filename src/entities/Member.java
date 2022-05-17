package entities;

import disciplins.Discipline;
import main.Date;
import ui.Ui;

import java.time.LocalDate;

public class Member {

  private Date birthday;
  private int age;
  private String membership;
  private String firstName;
  private String surname;
  private boolean active;
  private boolean competitionSwimmer;
  private boolean payment;
  private Trainer trainer;
  private LocalDate registerDate = LocalDate.now();
  private int id;
  private Discipline discipline;
  private Ui ui = new Ui();


  public Member(Date birthday, int id, String firstName, String surname,
                boolean competitionSwimmer, int idCode) {
    this.birthday = birthday;
    this.id = registerDate.getYear() * idCode + id;
    this.age = birthday.birthdayToAge();
    this.membership = birthday.membershipType();
    this.firstName = firstName;
    this.surname = surname;
    this.active = true;
    this.competitionSwimmer = competitionSwimmer;
    this.payment = true;
    this.discipline = new Discipline();
    trainer = null;
  }

  public int subscription(){
    int subscription;
    if(active == true){
      if(membership.equals("Junior")){
      subscription = 1000;
     } else if(membership.equals("Senior")){
        subscription = 1600;
      } else subscription = 1200;
    }else subscription = 500;
    return subscription;
  }

  public Discipline getDiscipline(){
    return discipline;
  }

  public Date getBirthday() {
    return birthday;
  }

  public int getId() {
    return id;
  }

  public Trainer getTrainer() {
    return trainer;
  }

  public LocalDate getRegisterDate() {
    return registerDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSurname(){
    return surname;
  }

  public boolean isActive() {
    return active;
  }

  public boolean isCompetitionSwimmer() {
    return competitionSwimmer;
  }

  public int getAge(){
    return age;
  }

  public void setTrainer(Trainer trainer) {
    this.trainer = trainer;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setCompetitionSwimmer(boolean competitionSwimmer) {
    this.competitionSwimmer = competitionSwimmer;
  }

  public boolean isPayment() {
    return payment;
  }

  public void setPayment(boolean payment) {
    this.payment = payment;
  }


  public String activeOrPassive(){
    String activeOrPassive;
    if(active == true){
      activeOrPassive = "Aktiv";
    } else activeOrPassive = "Passiv";
    return activeOrPassive;
  }

  public String compOrNotComp(){
    String competition;
    if(active == true){
      competition = "Konkurrencesvømmer";
    } else competition = "Motionssvømmer";
    return competition;
  }

  public String paidOrNotPaid(){
    String paidStatus;
    if(payment == true){
      paidStatus = "Betalt";
    } else paidStatus = ui.RED + "Ikke Betalt" + ui.RESET;
    return paidStatus;
  }

  public String trainerName(){
    String name = "";
    if(trainer != null){
        name = trainer.getName();
    } return name;
  }

    public String shortenSurname() {
        if (surname.length() > 20) {
            return surname.substring(0, 16) + "...";
        } else return surname;
    }

  public String shortenFirstname(){
    if(firstName.length() > 15){
      return firstName.substring(0,14) + "...";
    } else return firstName;
  }

  public String toString(){
    return String.format("ID: %-9d | Efternavn: %-20s | Fornavn: %-18s | %10s (%-2sår) | %-6s | %-6s | %11s | %-18s | Træner: %-5s | ",
        id, shortenSurname(), shortenFirstname(), birthday.getBirthday(), age, membership, activeOrPassive(), paidOrNotPaid(),
        compOrNotComp(), trainerName()) + registerDate + "\n";
  }
}
