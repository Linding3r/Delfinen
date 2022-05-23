package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;
import entities.AgeGroup;

public class Date {

    private int day;
    private int month;
    private int year;
    private int age;
    Scanner sc = new Scanner(System.in);
    private String date;
    private LocalDate currentDate = LocalDate.now();

    public void setDate(String date) {
        this.date = date;
    }

    public String checkBirthday(JTextField textFieldAge) {
        date = (textFieldAge.getText());
        String[] birthdayArray = date.split("/");
        try {
            for (int i = 0; i < birthdayArray.length; i++) {
                day = Integer.parseInt(birthdayArray[0]);
                month = Integer.parseInt(birthdayArray[1]);
                year = Integer.parseInt(birthdayArray[2]);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ignored) {
        }
        Border br = BorderFactory.createLineBorder(Color.red);
        if (!(day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900
            && year <= Integer.parseInt(String.valueOf(Year.now())))) {
            textFieldAge.setBorder(br);
            return null;
        } else
            br = BorderFactory.createLineBorder(Color.WHITE);
        textFieldAge.setBorder(br);
        return date;
    }

    public String createDate() {
        date = sc.nextLine();
        String[] birthdayArray = date.split("/");
        try {
            for (int i = 0; i < birthdayArray.length; i++) {
                day = Integer.parseInt(birthdayArray[0]);
                month = Integer.parseInt(birthdayArray[1]);
                year = Integer.parseInt(birthdayArray[2]);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ignored) {
        }
        while (!(day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900
            && year <= Integer.parseInt(String.valueOf(Year.now())))) {
            System.out.println((Arrays.toString(birthdayArray).replace("{", "").replace("}", "")) +
                " Er en ugyldig dato. Indtast ny dato:");
            date = sc.nextLine();
            createDate();
        }
        return date;
    }

    public String checkDateFromCSV() {
        String[] birthdayArray = date.split("/");
        try {
            for (int i = 0; i < birthdayArray.length; i++) {
                day = Integer.parseInt(birthdayArray[0]);
                month = Integer.parseInt(birthdayArray[1]);
                year = Integer.parseInt(birthdayArray[2]);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ignored) {
        }
        return date;
    }

    public String getDate() {
        return date;
    }

    public int getAge() {
        return age;
    }

    public int birthdayToAge() {
        int ageYear = currentDate.getYear() - year;
        int ageMonth = currentDate.getMonthValue() - month;
        int ageDay = currentDate.getDayOfMonth() - day;

        if (ageMonth < 0 || ageDay < 0) {
            if (ageMonth < 0) {
                ageYear--;
            }
            if (ageDay < 0) {
                ageMonth--;
                if (ageMonth < 0) {
                    ageYear--;

                }
            }
        }
        return age = ageYear;
    }


        public int getYear () {
            return year;
        }

        public Enum ageGroupType() {
            if (age < 18) {
                return AgeGroup.JUNIOR;
            } else if (age >= 18 && age < 60) {
                return AgeGroup.SENIOR;
            } else return AgeGroup.SIXTY;
        }

        @Override
        public String toString () {
            return date;
        }
    }
