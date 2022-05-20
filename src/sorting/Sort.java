package sorting;


import disciplins.SwimmingTime;
import disciplins.Time;
import entities.Member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.comparing;


public class Sort {

  public void sortSurname(ArrayList<Member> memberList) {
    if (memberList != null) {
      Collections.sort(memberList, Comparator.comparing(Member::getSurname));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortFirstname(ArrayList<Member> memberList) {
    if (memberList != null) {
      Collections.sort(memberList, Comparator.comparing(Member::getFirstName));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortAge(ArrayList<Member> memberList) {
    if (memberList != null) {
      Collections.sort(memberList, Comparator.comparing(Member::getAge));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortRegDate(ArrayList<Member> memberList) {
    if (memberList != null) {
      Collections.sort(memberList, Comparator.comparing(Member::getRegisterDate));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortActive(ArrayList<Member> memberList) {
    if (memberList != null) {
      Collections.sort(memberList, Comparator.comparing(Member::isActive));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortComp(ArrayList<Member> memberList) {
    if (memberList != null) {
      Collections.sort(memberList, Comparator.comparing(Member::isCompetitionSwimmer));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortId(ArrayList<Member> memberList) {
    if (memberList != null) {
      Collections.sort(memberList, Comparator.comparing(Member::getId));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }

  public void sortPayment(ArrayList<Member> memberList){
    if (memberList != null) {
      Collections.sort(memberList, Comparator.comparing(Member::isPayment));
    } else System.out.println("Der er ingen medlemmer på listen til at sortere!");
  }


}
