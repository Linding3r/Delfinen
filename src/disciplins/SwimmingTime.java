package disciplins;

import main.Date;

public class SwimmingTime {

  private String competitionName;
  private Date date;
  private Integer position;
  private SwimmingStyle swimmingStyle;


  public SwimmingTime() {
    this.competitionName = null;
    this.position = null;
    this.swimmingStyle = new SwimmingStyle();
    date = new Date();
  }

  public String getName() {
    return competitionName;
  }

  public void setName(String name) {
    this.competitionName = name;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
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

  public void setDate(Date date) {
    this.date = date;
  }
}



