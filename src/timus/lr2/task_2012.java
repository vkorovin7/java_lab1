package timus.lr2;

import java.util.Scanner;

public class task_2012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Соревнование по программированию ===\n");

        // Ввод количества задач, которые Гриша решит за первый час
        System.out.println("Введите количество задач, которые Гриша решит за первый час (1-11):");
        int f = scanner.nextInt();

        // Проверка на корректность ввода
        if (f < 1 || f > 11) {
            System.out.println("Ошибка: число должно быть от 1 до 11!");
            scanner.close();
            return;
        }

        // Константы
        int totalTime = 5 * 60;        // 5 часов = 300 минут
        int firstHour = 60;            // Первый час = 60 минут
        int remainingTime = totalTime - firstHour;  // 240 минут
        int totalProblems = 12;        // Всего задач
        int timePerProblem = 45;       // 45 минут на задачу после первого часа

        // Количество оставшихся задач после первого часа
        int remainingProblems = totalProblems - f;

        // Время, необходимое для решения оставшихся задач
        int timeNeeded = remainingProblems * timePerProblem;

        // Вывод результата
        System.out.println("\n=== Расчёт ===");
        System.out.println("За первый час решено задач: " + f);
        System.out.println("Осталось задач: " + remainingProblems);
        System.out.println("Времени осталось: " + remainingTime + " минут");
        System.out.println("Времени нужно: " + timeNeeded + " минут");

        System.out.println("\n=== Результат ===");
        if (timeNeeded <= remainingTime) {
            System.out.println("YES");
            System.out.println("Гриша успеет решить все задачи!");
        } else {
            System.out.println("NO");
            System.out.println("Гриша не успеет решить все задачи!");
        }

        scanner.close();
    }
}
