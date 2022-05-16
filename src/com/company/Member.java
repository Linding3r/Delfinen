package com.company;

public class Member {

  private Integer age;
  private int id;
  private String name;
  private boolean active;
  private boolean competitionSwimmer;
  private Trainer trainer;



  public Member(Integer age, int id, String name, boolean active, boolean competitionSwimmer) {
    this.age = age;
    this.id = id;
    this.name = name;
    this.active = active;
    this.competitionSwimmer = competitionSwimmer;
  }

  public Integer getAge() {
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

  public void setAge (Integer age){
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
    return "Navn: " + name  + " | Alder: " + age + " | id: " + id + " | Aktiv: " + yesNoActive + " | Konkurrencesvømmer: "+ yesNoComp + "\n";
  }
}
