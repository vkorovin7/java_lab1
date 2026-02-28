package lr1;

import java.util.Scanner;
import java.time.Year;

public class Example11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите год рождения: ");
        int birthYear = scanner.nextInt();

        int currentYear = Year.now().getValue();

        int age = currentYear - birthYear;

        System.out.println("Пользователь: " + name + ", Возраст: " + age);

        scanner.close();
    }
}
