package main;

import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;

public class Birthday {
    private int day;
    private int month;
    private int year;
    Scanner sc = new Scanner(System.in);

    public void checkBirthday(String birthday) {
        String[] birthdayArray = birthday.split("/");
        try {
            for (int i = 0; i < birthdayArray.length; i++) {
                day = Integer.parseInt(birthdayArray[0]);
                month = Integer.parseInt(birthdayArray[1]);
                year = Integer.parseInt(birthdayArray[2]);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        while (!(day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900 && year <= Integer.parseInt(String.valueOf(Year.now())))) {
            System.out.println((Arrays.toString(birthdayArray).replace("{","").replace("}","")) + " Er en ugyldig fødselsdagsdato. Indtast ny dato:");
            birthday = sc.nextLine();
            checkBirthday(birthday);
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
