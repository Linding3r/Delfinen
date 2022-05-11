package com.company;

public class Medlem {

  private Integer age;
  private int id;
  private String name;
  private boolean aktiv;
  private boolean konkurrenceSvømmer;


  public Medlem(Integer age, int id, String name, boolean aktiv, boolean konkurrenceSvømmer) {
    this.age = age;
    this.id = id;
    this.name = name;
    this.aktiv = aktiv;
    this.konkurrenceSvømmer = konkurrenceSvømmer;
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

  public boolean isAktiv() {
    return aktiv;
  }

  public boolean isKonkurrenceSvømmer() {
    return konkurrenceSvømmer;
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

  public void setAktiv(boolean aktiv) {
    this.aktiv = aktiv;
  }

  public void setKonkurrenceSvømmer(boolean konkurrenceSvømmer) {
    this.konkurrenceSvømmer = konkurrenceSvømmer;
  }


  public String toString (){
    return "Alder: " + age + "\nid: " + id + "\nNavn: " + name + "\nAktiv/ikke aktiv: " + aktiv + "\nKonkurrence/Motionssvømmer: "+ konkurrenceSvømmer;
  }
}
