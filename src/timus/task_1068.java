package timus;

import java.util.Scanner;

public class task_1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sum = 0;
        if (n >= 1) {
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
        } else {
            for (int i = n; i <= 1; i++) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
