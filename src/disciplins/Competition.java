package disciplins;

public class Competition {

  private SwimmingTime swimmingTime;
  private String competitionName;
  private int memberId;
  private String placement;

  public Competition (SwimmingTime swimmingTime, String competition, int memberId, String placement){
    this.swimmingTime = swimmingTime;
    this.competitionName = competition;
    this.memberId = memberId;
    this.placement = placement;
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
    return competitionName + " " + memberId + " " + placement + " " + swimmingTime.getTime().getTime();
  }

}
