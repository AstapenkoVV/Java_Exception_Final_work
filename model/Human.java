package ru.gb.oop.exeption.total.model;

import ru.gb.oop.exeption.total.exception.EnteredValuesException;

import java.util.ArrayList;

public class Human {
    private String person;
    private String dateOfBirth;
    private String phoneNumber;
    private String gender;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    DateValidatorUsingLocalDate dateValidatorUsingLocalDate = new DateValidatorUsingLocalDate();

    public ArrayList<String> createPerson(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] parts = str.split(" ");

        Integer countSpace = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') countSpace++;
        }
        fileName = parts[0] + ".txt";
        person = parts[0] + " " + parts[1] + " " + parts[2];
        dateOfBirth = parts[3];
        phoneNumber = parts[4];
        gender = parts[5];

        try {
            if (countSpace < 5)
                throw new EnteredValuesException("Введено меньше данных чем требуется!");
            if (countSpace > 5)
                throw new EnteredValuesException("Вы ввели больше данных чем требуется!");

            if (!dateValidatorUsingLocalDate.isValidDate(dateOfBirth))
                throw new RuntimeException("Не верно указан год рождения!");

            if (parts[4].length() != 11)
                throw new EnteredValuesException("Телефон должен быть в формате XXXXXXXXXXX");
            Long.parseLong(phoneNumber);

            if (!gender.equals("f") && !gender.equals("m"))
                throw new IllegalAccessException("Вы не верно указали пол!" +
                        "\nПол должен быть либо 'f' либо 'm'");

            arrayList.add(person);
            arrayList.add(dateOfBirth);
            arrayList.add(phoneNumber);
            arrayList.add(gender);
        } catch (EnteredValuesException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Указан не верный тип номера телефона!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
}
