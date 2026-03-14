package lr2;

import java.util.Random;

public class Example1 {
    public static void main(String[] args) {
        // Создаем массив размером 15 элементов
        int[] array = new int[15];
        Random random = new Random();

        // Заполняем массив случайными числами от 0 до 50
        // Диапазон выбран небольшим, чтобы увеличить вероятность появления одинаковых минимальных значений
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(51);
        }
        // Выводим массив в консоль
        System.out.print("Массив: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        // Находим минимальное значение
        // Инициализируем минимальное значение первым элементом массива
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        // Выводим минимальное значение
        System.out.println("Минимальное значение: " + minValue);
        // Находим и выводим индексы всех элементов с минимальным значением
        System.out.print("Индексы элементов с минимальным значением: ");
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == minValue) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Не найдено (ошибка логики)");
        } else {
            System.out.println(); // Перенос строки в конце
        }
    }
}