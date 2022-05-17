package main;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;

public class Date {
    private int day;
    private int month;
    private int year;
    private int age;
    Scanner sc = new Scanner(System.in);
    private String birthday;
    private LocalDate currentDate = LocalDate.now();

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String checkDate() {
        birthday = sc.nextLine();
        String[] birthdayArray = birthday.split("/");
        try {
            for (int i = 0; i < birthdayArray.length; i++) {
                day = Integer.parseInt(birthdayArray[0]);
                month = Integer.parseInt(birthdayArray[1]);
                year = Integer.parseInt(birthdayArray[2]);
            }
        } catch (ArrayIndexOutOfBoundsException  | NumberFormatException ignored) {
        }
        while (!(day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900
            && year <= Integer.parseInt(String.valueOf(Year.now())))) {
            System.out.println((Arrays.toString(birthdayArray).replace("{","").replace("}","")) +
                " Er en ugyldig dato. Indtast ny dato:");
            birthday = sc.nextLine();
            checkDate();
        }
        return birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public int birthdayToAge(){
        int ageYear = currentDate.getYear() - year;
        int ageMonth = currentDate.getMonthValue() - month;
        int ageDay = currentDate.getDayOfMonth() - day;

        if(ageMonth < 0 || ageDay < 0) {
            if (ageMonth < 0) {
                ageYear--;
            } if(ageDay < 0){
                ageMonth--;
                if(ageMonth < 0) {
                    ageYear--;

                }
            }
        } return age = ageYear;
    }

    public String membershipType(){
        if(age < 18){
            return "Junior";
        } else if (age >= 18 && age < 60){
            return "Senior";
        }else return "60+";
    }

    @Override
    public String toString() {
        return birthday;
    }
}