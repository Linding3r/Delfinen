package entities;

import disciplins.Discipline;
import main.Birthday;

import java.time.LocalDate;

public class Member {

  private Birthday birthday;
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


  public Member(Birthday birthday, int id, String firstName, String surname, boolean active,
                boolean competitionSwimmer, boolean payment, int idCode) {
    this.birthday = birthday;
    this.id = registerDate.getYear() * idCode + id;
    this.age = birthday.birthdayToAge();
    this.membership = birthday.membershipType();
    this.firstName = firstName;
    this.surname = surname;
    this.active = active;
    this.competitionSwimmer = competitionSwimmer;
    this.payment = payment;
    this.discipline = new Discipline();

  }

  public Discipline getCompetiton(){
    return discipline;
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

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setSurname(String surname){
    this.surname = surname;
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
    } else paidStatus = "Ikke Betalt";
    return paidStatus;
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
    return String.format("ID: %-9d | Efternavn: %-20s | Fornavn: %-18s | %10s (%-2sår) | %-6s | %-6s | %11s | %-18s | ",
        id, shortenSurname(), shortenFirstname(), birthday.getBirthday(), age, membership, activeOrPassive(), paidOrNotPaid(),
        compOrNotComp()) + registerDate + "\n";
  }
}
