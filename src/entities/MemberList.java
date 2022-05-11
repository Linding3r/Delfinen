package entities;

import ui.Ui;

import java.util.ArrayList;

public class MemberList {
  private ArrayList<Member> memberList = new ArrayList<>();
  Ui ui = new Ui();

  public void addMemberToList(Member member){
    memberList.add(member);
  }

  @Override
  public String toString() {
    String member = "\n";
    for(int i = 0; i< memberList.size(); i++){
      member += memberList.get(i).toString();
    }
    return ui.asciiLines() + "\n" + member + "\n" + ui.asciiLines() + "\n\n\n";
  }
}
