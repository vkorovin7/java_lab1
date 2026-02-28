package lr1;

import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод имени
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        // Ввод возраста
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        // Вывод информации
        System.out.println("Имя: " + name + ", Возраст: " + age);

        scanner.close();
    }
}
