package lr7.task6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String myPath = "src/lr7/task6";
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String fileName = in.nextLine();
        System.out.print("Введите слово для поиска: ");
        String wordToSearch = in.nextLine();
        String finalFileName = myPath + File.separator + fileName + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(finalFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(wordToSearch)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}