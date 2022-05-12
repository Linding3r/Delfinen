package entities;

import java.time.LocalDate;

public class Member {

  private int id;
  private Integer age;
  private String firstName;
  private String surname;
  private boolean active;
  private boolean competitionSwimmer;
  private boolean payment;
  private Trainer trainer;
  private LocalDate registerDate = LocalDate.now();

  public Member(Integer age, int id, String name, boolean active, boolean competitionSwimmer) {
    this.age = age;
    this.id = id;
    this.firstName = firstName;
    this.surname = surname;
    this.active = active;
    this.competitionSwimmer = competitionSwimmer;
    this.payment = payment;

  }

  public Integer getAge() {
    return age;
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

  public void setAge (Integer age){
    this.age = age;
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

  public String shortenSurname(){
    if(surname.length() > 20){
      return surname.substring(0,16) + "...";
    } else return surname;
  }

  public String shortenFirstname(){
    if(firstName.length() > 15){
      return firstName.substring(0,14) + "...";
    } else return firstName;
  }

  public String toString(){
    return String.format("ID: %-7d | Efternavn: %-20s | Fornavn: %-18s | Alder: %2d | %-6s | %-17s | ", id, shortenSurname(), shortenFirstname(), age, activeOrPassive(),compOrNotComp()) + registerDate + "\n";
  }


  /*public String toString (){
    return "ID: " + id + " | Navn: " + name + " | Alder: " + age + " | " + activeOrPassive() +
        " | " + compOrNotComp() + " | " + registerDate + "\n";
  }*/
}
