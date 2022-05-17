package com.company;

public class Member {

  private Birthday birthday;
  private int age;
  private int id;
  private String firstName;
  private String surname;
  private boolean active;
  private boolean competitionSwimmer;
  private Trainer trainer;
  private String membership;
  private boolean payment;

  public Member(Birthday birthday, int id, String firstName, String surname, boolean active, boolean competitionSwimmer) {
    this.birthday = birthday;
    this.age = birthday.birthdayToAge();
    this.id = id;
    this.membership = birthday.membershipType();
    this.firstName = firstName;
    this.surname = surname;
    this.active = active;
    this.competitionSwimmer = competitionSwimmer;
    this.payment = true;
  }

  public String getSurname() {
    return surname;
  }

  public boolean isPayment() {
    return payment;
  }

  public void setPayment(boolean payment) {
    this.payment = payment;
  }

  public Birthday getBirthday() {
    return birthday;
  }

  public int getAge() {
    return age;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public boolean isActive() {
    return active;
  }

  public boolean isCompetitionSwimmer() {
    return competitionSwimmer;
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

  public String toString (){
    String yesNoActive;
    String yesNoComp;

    if (competitionSwimmer) {
      yesNoComp = "Ja";
    } else yesNoComp = "Nej (motionssvømmer)";
    if (active) {
      yesNoActive = "Ja";
    } else yesNoActive = "Nej";
    return "Fornavn: " + firstName + " | Efternavn: " + surname + " | Fødselsdagsdato: " + birthday.getBirthday() + " | id: " + id + " | Aktiv: " + yesNoActive + " | Konkurrencesvømmer: "+ yesNoComp + "\n";
  }
}
