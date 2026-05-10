package timus.lr6;

import java.util.Scanner;

public class task_1924 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // Проверяем остаток от деления n на 4
        if (n % 4 == 0 || n % 4 == 3) {
            System.out.println("black");
        } else {
            System.out.println("grimy");
        }
    }
}
