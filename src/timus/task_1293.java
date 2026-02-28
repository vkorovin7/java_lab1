package timus;

import java.util.Scanner;

public class task_1293 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int totalSulfide = n * a * b * 2;

            System.out.println(totalSulfide);
        }

        scanner.close();
    }
}
