package disciplins;

import main.Date;

public class SwimmingTime {

  private String competitionName;
  private Time time;
  private Date date;
  private Integer position;
  private SwimmingStyle swimmingStyle;


  public SwimmingTime() {
    this.competitionName = null;
    this.position = null;
    this.swimmingStyle = swimmingStyle;
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

  public SwimmingStyle getStyle(){
    return swimmingStyle;
  }

  public void setStyle(SwimmingStyle swimmingStyle){
    this.swimmingStyle = swimmingStyle;
  }
}



