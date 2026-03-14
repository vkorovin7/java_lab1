package timus.lr2;

import java.util.Scanner;

public class task_1785 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Перевод чисел на язык аниндилъяква ===\n");

        // Ввод количества монстров
        System.out.println("Введите количество монстров (1-2000):");
        int n = scanner.nextInt();

        // Проверка на корректность ввода
        if (n < 1 || n > 2000) {
            System.out.println("Ошибка: число должно быть от 1 до 2000!");
            scanner.close();
            return;
        }

        // Определение слова по количеству монстров
        String word = getAnindilyakwaWord(n);

        // Вывод результата
        System.out.println("\n=== Результат ===");
        System.out.println("Количество монстров: " + n);
        System.out.println("На языке аниндилъяква: " + word);

        scanner.close();
    }

    // Метод для определения слова по количеству монстров
    public static String getAnindilyakwaWord(int n) {
        if (n >= 1 && n <= 4) {
            return "few";
        } else if (n >= 5 && n <= 9) {
            return "several";
        } else if (n >= 10 && n <= 19) {
            return "pack";
        } else if (n >= 20 && n <= 49) {
            return "lots";
        } else if (n >= 50 && n <= 99) {
            return "horde";
        } else if (n >= 100 && n <= 249) {
            return "throng";
        } else if (n >= 250 && n <= 499) {
            return "swarm";
        } else if (n >= 500 && n <= 999) {
            return "zounds";
        } else if (n >= 1000) {
            return "legion";
        } else {
            return "unknown";
        }
    }
}