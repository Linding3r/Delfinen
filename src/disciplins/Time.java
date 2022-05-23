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
          " Er en ugyldig tid. Indtast venligst ny tid i formatet: DD/MM/YYYY ");
      time = sc.nextLine();
      competitionTime();
    }
    String min = "" + minutes;
    String sec = "" + seconds;
    String milisec = "" + miliseconds;
    if (minutes <= 9){
      min = "0" + minutes;
    } if (minutes == 0){
      min = "00";
    } if (seconds <= 9){
      sec = "0" + seconds;
    } if (seconds == 0){
      sec = "00";
    } if (miliseconds <= 99){
      milisec = "0" + miliseconds;
    } if (miliseconds <= 9){
      milisec = "00" + miliseconds;
    }
    time = min + ":" + sec + ":" + milisec;
    return time;
  }

  public boolean competitionTimeCsv(String time) {
    if (time.equals("null")) {
      return false;
    } else {
      String[] timeArray = time.split(":");
      try {
        for (int i = 0; i < timeArray.length; i++) {
          minutes = Integer.parseInt(timeArray[0]);
          seconds = Integer.parseInt(timeArray[1]);
          miliseconds = Integer.parseInt(timeArray[2]);
        }
      } catch (ArrayIndexOutOfBoundsException | NumberFormatException ignored) {
      }
      String min = "" + minutes;
      String sec = "" + seconds;
      String milisec = "" + miliseconds;
      if (minutes <= 9){
        min = "0" + minutes;
      } if (minutes == 0){
        min = "00";
      } if (seconds <= 9){
        sec = "0" + seconds;
      } if (seconds == 0){
        sec = "00";
      } if (miliseconds <= 99){
        milisec = "0" + miliseconds;
      } if (miliseconds <= 9){
        milisec = "00" + miliseconds;
      }
      time = min + ":" + sec + ":" + milisec;
      this.time = time;
      return true;
    }
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
