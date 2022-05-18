package main;


import entities.Member;

import java.util.Collections;
import java.util.Comparator;

import static main.Engine.memberList;


public class Sort {

  public void sortSurname() {
    if (memberList.getMemberList() != null) {
      Collections.sort(memberList.getMemberList(), Comparator.comparing(Member::getSurname));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortFirstname() {
    if (memberList.getMemberList() != null) {
      Collections.sort(memberList.getMemberList(), Comparator.comparing(Member::getFirstName));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortAge() {
    if (memberList.getMemberList() != null) {
      Collections.sort(memberList.getMemberList(), Comparator.comparing(Member::getAge));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortRegDate() {
    if (memberList.getMemberList() != null) {
      Collections.sort(memberList.getMemberList(), Comparator.comparing(Member::getRegisterDate));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortActive() {
    if (memberList.getMemberList() != null) {
      Collections.sort(memberList.getMemberList(), Comparator.comparing(Member::isActive));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortComp() {
    if (memberList.getMemberList() != null) {
      Collections.sort(memberList.getMemberList(), Comparator.comparing(Member::isCompetitionSwimmer));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortId() {
    if (memberList.getMemberList() != null) {
      Collections.sort(memberList.getMemberList(), Comparator.comparing(Member::getId));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortPayment(){
    if (memberList.getMemberList() != null) {
      Collections.sort(memberList.getMemberList(), Comparator.comparing(Member::isPayment));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }
}
