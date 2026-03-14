package timus.lr2;

import java.util.Scanner;

public class task_2001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Математики и ягоды ===\n");

        // Ввод данных трёх взвешиваний
        System.out.println("Введите результаты первого взвешивания (a1 b1):");
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();

        System.out.println("Введите результаты второго взвешивания (a2 b2):");
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();

        System.out.println("Введите результаты третьего взвешивания (a3 b3):");
        int a3 = scanner.nextInt();
        int b3 = scanner.nextInt();

        // Вычисление массы ягод каждого математика
        // После второго взвешивания: корзина второго пуста (b2 = вес пустой корзины второго)
        // После третьего взвешивания: корзина первая пуста (a3 = вес пустой корзины первого)

        // Вес пустой корзины первого математика
        int basket1 = a3;

        // Вес пустой корзины второго математика
        int basket2 = b2;

        // Масса ягод первого математика = первое взвешивание - вес пустой корзины
        int berries1 = a1 - basket1;

        // Масса ягод второго математика = первое взвешивание - вес пустой корзины
        int berries2 = b1 - basket2;

        // Вывод результата
        System.out.println("\n=== Результат ===");
        System.out.println("Масса ягод первого математика: " + berries1);
        System.out.println("Масса ягод второго математика: " + berries2);
        System.out.println("\nОтвет: " + berries1 + " " + berries2);

        // Проверка корректности (для отладки)
        System.out.println("\n=== Проверка ===");
        System.out.println("Вес пустой корзины 1: " + basket1);
        System.out.println("Вес пустой корзины 2: " + basket2);
        System.out.println("Общая масса ягод: " + (berries1 + berries2));
        System.out.println("a2 (все ягоды у первого): " + (basket1 + berries1 + berries2));
        System.out.println("b3 (все ягоды у второго): " + (basket2 + berries1 + berries2));

        scanner.close();
    }
}
