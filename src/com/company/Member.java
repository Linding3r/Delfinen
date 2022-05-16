package com.company;

public class Member {

/*  private main.Birthday birthday;
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
  private ArrayList<Competition> competiton;


  public Member(main.Birthday birthday, int id, String firstName, String surname, boolean active,
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
    this.competiton = new ArrayList<>();

  }*/

  private Birthday birthday;
  private int age;
  private int id;
  private String name;
  private boolean active;
  private boolean competitionSwimmer;
  private Trainer trainer;

  public Member(Birthday birthday, int id, String name, boolean active, boolean competitionSwimmer) {
    this.birthday = birthday;
    this.age = birthday.birthdayToAge();
    this.id = id;
    this.name = name;
    this.active = active;
    this.competitionSwimmer = competitionSwimmer;
  }

  public int getAge() {
    return age;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public boolean isActive() {
    return active;
  }

  public boolean isCompetitionSwimmer() {
    return competitionSwimmer;
  }

  public void setAge (int age){
    this.age = age;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setKonkurrenceSvømmer(boolean competitionSwimmer) {
    this.competitionSwimmer = competitionSwimmer;
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
    return "Navn: " + name  + " | Fødselsdagsdato: " + age + " | id: " + id + " | Aktiv: " + yesNoActive + " | Konkurrencesvømmer: "+ yesNoComp + "\n";
  }
}
