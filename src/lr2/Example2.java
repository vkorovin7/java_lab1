package lr2;

public class Example2 {
    public static void main(String[] args) {
        // Создаем двумерный массив (можно изменить размеры)
        int rows = 6;
        int cols = 8;
        int[][] array = new int[rows][cols];

        int value = 0;

        // Заполняем массив "змейкой"
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                // Чётная строка (0, 2, 4...) - слева направо
                for (int j = 0; j < cols; j++) {
                    array[i][j] = value++;
                }
            } else {
                // Нечётная строка (1, 3, 5...) - справа налево
                for (int j = cols - 1; j >= 0; j--) {
                    array[i][j] = value++;
                }
            }
        }

        // Выводим массив в консоль
        System.out.println("Заполненный массив змейкой:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.println();
        }
    }
}