package disciplins;

import main.Date;

public class Discipline {

  private String competitionName;
  private Time time;
  private Date date;
  private Integer position;
  private Integer butterfly;
  private Integer crawl;
  private Integer backcrawl;
  private Integer breaststroke;


  public Discipline() {
    this.competitionName = null;
    this.position = null;
    this.butterfly = null;
    this.crawl = null;
    this.backcrawl = null;
    this.breaststroke = null;
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

  public int getButterfly() {
    return butterfly;
  }

  public void setButterfly(Integer butterfly) {
    this.butterfly = butterfly;
  }

  public int getCrawl() {
    return crawl;
  }

  public void setCrawl(Integer crawl) {
    this.crawl = crawl;
  }

  public Integer getBackcrawl() {
    return backcrawl;
  }

  public void setBackcrawl(Integer backcrawl) {
    this.backcrawl = backcrawl;
  }

  public Integer getBreaststroke() {
    return breaststroke;
  }

  public void setBreaststroke(Integer breaststroke) {
    this.breaststroke = breaststroke;
  }
}



