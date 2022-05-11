package com.company;

import java.util.ArrayList;

public class MemberList {
  private ArrayList<Member> memberList = new ArrayList<>();

  public void addMemberToList(Member member){
    memberList.add(member);
  }

  public ArrayList<Member> getMemberList() {
    return memberList;
  }

  @Override
  public String toString() {
    return "MemberList{" +
        "memberList=" + memberList +
        '}';
  }
}
