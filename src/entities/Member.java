package entities;

import java.time.LocalDate;

public class Member {

  private Integer age;
  private int id;
  private String name;
  private boolean active;
  private boolean competitionSwimmer;
  private Trainer trainer;
  private LocalDate registerDate = LocalDate.now();



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

  public void setName(String name) {
    this.name = name;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setKonkurrenceSvømmer(boolean competitionSwimmer) {
    this.competitionSwimmer = competitionSwimmer;
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
      competition = "Konkurencesvømmer";
    } else competition = "Motionssvømmer";
    return competition;
  }

  public String toString(){
    return String.format("ID: %-7d | Navn: %-20s | Alder: %2d | %-6s | %-17s | ", id, name, age, activeOrPassive(),compOrNotComp()) + registerDate + "\n";
  }


  /*public String toString (){
    return "ID: " + id + " | Navn: " + name + " | Alder: " + age + " | " + activeOrPassive() +
        " | " + compOrNotComp() + " | " + registerDate + "\n";
  }*/
}
