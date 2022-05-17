package disciplins;

public class SwimmingStyle {
  Time butterfly;
  Time crawl;
  Time backcrawl;
  Time breaststroke;

  public SwimmingStyle() {
    this.butterfly = null;
    this.crawl = null;
    this.backcrawl = null;
    this.breaststroke = null;
  }

  public Time getButterfly() {
    return butterfly;
  }

  public void setButterfly(Time butterfly) {
    this.butterfly = butterfly;
  }

  public Time getCrawl() {
    return crawl;
  }

  public void setCrawl(Time crawl) {
    this.crawl = crawl;
  }

  public Time getBackcrawl() {
    return backcrawl;
  }

  public void setBackcrawl(Time backcrawl) {
    this.backcrawl = backcrawl;
  }

  public Time getBreaststroke() {
    return breaststroke;
  }

  public void setBreaststroke(Time breaststroke) {
    this.breaststroke = breaststroke;
  }
}
