package ru.gb.oop.exeption.total.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidatorUsingLocalDate {
    private static final String DATE_FORMAT = "dd.MM.yyyy";
    private static String[] inputData;
    private static Integer year;

    public static boolean isValidDate(String date) {
        inputData = date.split("\\.");
        year = Integer.parseInt(inputData[2]);
        if (year > 1940 && year < 2020) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.parse(date);
                return true;
            } catch (ParseException e) {
                System.out.println("Верный формат даты рождения dd.MM.yyyy");
            }
        }
        return false;
    }
}
