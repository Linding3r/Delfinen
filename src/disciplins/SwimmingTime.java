package disciplins;

import main.Date;

public class SwimmingTime {

  private String competitionName;
  private Date date;
  private String position;
  private SwimmingStyle swimmingStyle;
  private Time time;

  public SwimmingTime() {
    competitionName = null;
    position = null;
    swimmingStyle = null;
    this.date = new Date();
    this.time = new Time();
  }

  public SwimmingTime(Date date, Time time) {
    competitionName = null;
    position = null;
    swimmingStyle = null;
    this.date = date;
    this.time = time;
  }

  public void setCompetitionName(String competitionName) {
    this.competitionName = competitionName;
  }

  public Time getTime() {
    return time;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public SwimmingStyle getSwimmingStyle(){
    return swimmingStyle;
  }

  public void setSwimmingStyle(SwimmingStyle swimmingStyle){
    this.swimmingStyle = swimmingStyle;
  }

  public Date getDate() {
    return date;
  }
}



