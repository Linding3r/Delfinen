package disciplins;

public class Discipline {

  private String name;
  private Integer position;
  private Integer butterfly;
  private Integer crawl;
  private Integer backcrawl;
  private Integer chest;


  public Discipline() {
    this.name = null;
    this.position = null;
    this.butterfly = null;
    this.crawl = null;
    this.backcrawl = null;
    this.chest = null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public Integer getChest() {
    return chest;
  }

  public void setChest(Integer chest) {
    this.chest = chest;
  }
}



