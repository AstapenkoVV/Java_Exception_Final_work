package ru.gb.oop.exeption.total.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
    public void writeFile(String fileName, ArrayList list) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            StringBuilder stringBuilder = new StringBuilder();
            for (Object str : list) {
                stringBuilder.append("<" + str + "> ");
            }
            stringBuilder.append('\n');
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
