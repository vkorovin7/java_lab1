package lr7.task8;

import lr7.task_1_2.Example7.Person;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Cars car = new Cars("Lada", 1500000, true);

        try {
            FileOutputStream fileOut = new FileOutputStream("src/lr7/task8/car.json");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(car);
            out.close();
            fileOut.close();
            System.out.println("Объект записан в car.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Cars restoreCar = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/lr7/task8/car.json");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            restoreCar = (Cars) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Объект считан!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Объект после считывания: ");
        System.out.println(restoreCar);
    }
}
