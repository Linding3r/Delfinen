package entities;

import main.Birthday;

import java.time.LocalDate;

public class Member {

  private Birthday birthday;
  private String firstName;
  private String surname;
  private boolean active;
  private boolean competitionSwimmer;
  private boolean payment;
  private Trainer trainer;
  private LocalDate registerDate = LocalDate.now();
  private int id;
  private int age;

  public Member(Birthday birthday, int id, String firstName, String surname, boolean active, boolean competitionSwimmer, boolean payment, int idCode) {
    this.birthday = birthday;
    this.id = registerDate.getYear() * idCode + id;
    this.firstName = firstName;
    this.surname = surname;
    this.active = active;
    this.competitionSwimmer = competitionSwimmer;
    this.payment = payment;

  }

  public Birthday getBirthday() {
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

  public void setAge(int age){
    this.age = age;
  }

  public int getAge(){
    return age;
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


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setSurname(String surname){
    this.surname = surname;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setKonkurrenceSvømmer(boolean competitionSwimmer) {
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
    return String.format("ID: %-9d | Efternavn: %-20s | Fornavn: %-18s | Fødselsdag: %10s | %-6s | %-18s | ", id, shortenSurname(), shortenFirstname(), birthday.getBirthday(), activeOrPassive(),compOrNotComp()) + registerDate + "\n";
  }


  /*public String toString (){
    return "ID: " + id + " | Navn: " + name + " | Alder: " + age + " | " + activeOrPassive() +
        " | " + compOrNotComp() + " | " + registerDate + "\n";
  }*/
}
