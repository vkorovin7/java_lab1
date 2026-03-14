package timus.lr2;

import java.util.Scanner;

public class task_1409 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Стрельба по банкам ===\n");

        // Ввод количества банок, простреленных Гарри и Ларри
        System.out.println("Введите количество банок, простреленных Гарри:");
        int harryShot = scanner.nextInt();

        System.out.println("Введите количество банок, простреленных Ларри:");
        int larryShot = scanner.nextInt();

        // Общее количество банок
        // Так как они одновременно прострелили одну и ту же последнюю банку,
        // то общее количество = банки Гарри + банки Ларри - 1 (пересекающаяся банка)
        int totalCans = harryShot + larryShot - 1;

        // Количество банок, которые не прострелил Гарри
        // Это все банки справа от той, которую прострелил Гарри
        int harryNotShot = totalCans - harryShot;

        // Количество банок, которые не прострелил Ларри
        // Это все банки слева от той, которую прострелил Ларри
        int larryNotShot = totalCans - larryShot;

        // Вывод результата
        System.out.println("\n=== Результат ===");
        System.out.println("Банок не прострелил Гарри: " + harryNotShot);
        System.out.println("Банок не прострелил Ларри: " + larryNotShot);

        // Дополнительная информация для понимания
        System.out.println("\n=== Дополнительная информация ===");
        System.out.println("Всего банок было: " + totalCans);
        System.out.println("Гарри прострелил банки с 1 по " + harryShot);
        System.out.println("Ларри прострелил банки с " + (totalCans - larryShot + 1) + " по " + totalCans);
        System.out.println("Последняя банка (номер " + harryShot + ") была прострелена обоими одновременно");

        scanner.close();
    }
}
