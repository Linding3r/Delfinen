package disciplins;

import java.util.Arrays;
import java.util.Scanner;

public class Time {

  private int minutes;
  private int seconds;
  private int miliseconds;
  Scanner sc = new Scanner(System.in);
  private String time = sc.nextLine();

  public String competitionTime() {
    String[] timeArray = time.split(":");
    try {
      for (int i = 0; i < timeArray.length; i++) {
        minutes = Integer.parseInt(timeArray[0]);
        seconds = Integer.parseInt(timeArray[1]);
        miliseconds = Integer.parseInt(timeArray[2]);
      }
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException ignored) {
    }
    while (!(minutes >= 1 && minutes <= 60 && seconds >= 1 && seconds <= 60 && miliseconds >= 1
        && miliseconds <= 100)) {
      System.out.println((Arrays.toString(timeArray)) +
          " Er en ugyldig tid. Indtast venligst ny tid:");
      time = sc.nextLine();
      competitionTime();
    }
    return time;
  }

  public String getTime(){
    return time;
  }
}
