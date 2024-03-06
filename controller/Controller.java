package ru.gb.oop.exeption.total.controller;

import ru.gb.oop.exeption.Printer;
import ru.gb.oop.exeption.total.model.DataBase;
import ru.gb.oop.exeption.total.model.Human;
import ru.gb.oop.exeption.total.view.PrintResult;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private Human human;
    private DataBase dataBase;
    private PrintResult printResult;

    public Controller() {
        human = new Human();
        dataBase = new DataBase();
        printResult = new PrintResult();
    }


    public void start() {
        System.out.println("Введите данные в формате: " +
                "\nФамилия Имя Отчество дата_рождения номер_телефона пол");
        String inputStr = new Scanner(System.in).nextLine();
        ArrayList list = human.createPerson(inputStr);
        dataBase.writeFile(human.getFileName(), list);
        printResult.print();
    }
}
