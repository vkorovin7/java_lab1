package lr7.task7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String myPath = "src/lr7/task7";
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название файла для записи: ");
        String fileName = in.nextLine();
        System.out.print("Введите текст для записи в файл: ");
        String textToWrite = in.nextLine();
        String finalFileName = myPath + File.separator + fileName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(finalFileName))) {
            writer.write(textToWrite);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            return;
        }
        System.out.println("Текст успешно записан в файл.");
        System.out.println("Количество записанных символов: " + textToWrite.length());
    }
}
