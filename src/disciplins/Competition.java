package disciplins;

import main.Date;

public class Competition {

  private SwimmingTime swimmingTime;
  private String competitionName;
  private int memberId;
  private String placement;
  private Date date;

  public Competition (SwimmingTime swimmingTime, String competition, int memberId, String placement){
    this.swimmingTime = swimmingTime;
    this.competitionName = competition;
    this.memberId = memberId;
    this.placement = placement;
    this.date = swimmingTime.getDate();
  }

  public SwimmingTime getSwimmingTime() {
    return swimmingTime;
  }

  public String getCompetitionName() {
    return competitionName;
  }

  public int getMemberId() {
    return memberId;
  }

  public String getPlacement() {
    return placement;
  }

  public String toString (){
    return String.format("Stævne: %-40s | ID: %-7d | Dato: %-10s | Placering: %-2s | Tid: %-9s | ",
        competitionName, memberId, date, placement, swimmingTime.getTime().getTime()) + "\n";

  }

}