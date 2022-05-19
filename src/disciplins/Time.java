package disciplins;

import java.util.Arrays;
import java.util.Scanner;

public class Time {

  private int minutes;
  private int seconds;
  private int miliseconds;
  Scanner sc = new Scanner(System.in);
  private String time;
  // TODO: 19/05/2022 Implement local time instead 

  public String competitionTime() {
    time = sc.nextLine();
    String[] timeArray = time.split(":");
    try {
      for (int i = 0; i < timeArray.length; i++) {
        minutes = Integer.parseInt(timeArray[0]);
        seconds = Integer.parseInt(timeArray[1]);
        miliseconds = Integer.parseInt(timeArray[2]);
      }
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException ignored) {
    }
    while (!(minutes >= 0 && minutes <= 60 && seconds >= 0 && seconds <= 60 && miliseconds >= 0)) {
      System.out.println((Arrays.toString(timeArray)) +
          " Er en ugyldig tid. Indtast venligst ny tid:");
      time = sc.nextLine();
      competitionTime();
    }
    StringBuilder builder = new StringBuilder();
    if (seconds == 0){
      builder.append(minutes + ":00:"+miliseconds);
    }
    else if (miliseconds == 0){
      builder.append(minutes + ":" + seconds +":000");
    }
    else if (minutes <= 9){
      builder.append("0" + minutes+":"+seconds + ":" + miliseconds);
    }
    else if (seconds <=9){
      builder.append(minutes+":"+ "0"+seconds + ":" + miliseconds);
    }
    else if (miliseconds <=9){
      builder.append(minutes+":"+seconds + ":00" + miliseconds);

    }
    else builder.append(minutes + ":" + seconds + ":" + miliseconds);
    time = String.valueOf(builder);
    return time;
  }

  public String getTime(){
    return time;
  }

  public long getMinutes() {
    return minutes;
  }

  public void setMinutes(int minutes) {
    this.minutes = minutes;
  }

  public long getSeconds() {
    return seconds;
  }

  public void setSeconds(int seconds) {
    this.seconds = seconds;
  }

  public long getMiliseconds() {
    return miliseconds;
  }

  public void setMiliseconds(int miliseconds) {
    this.miliseconds = miliseconds;
  }
}
