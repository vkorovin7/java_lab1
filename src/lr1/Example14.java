package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        int first = n - 1;
        int second = n;
        int third = n + 1;


        long sum = (long) first + second + third;

        long fourth = sum * sum;

        System.out.println(first + " " + second + " " + third + " " + fourth);

        scanner.close();
    }
}
