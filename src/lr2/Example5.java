package lr2;

import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод длины
        System.out.println("Введите длину прямоугольника:");
        double length = scanner.nextDouble();

        // Ввод ширины
        System.out.println("Введите ширину прямоугольника:");
        double width = scanner.nextDouble();

        // Создание объекта класса Rectangle
        Rectangle rectangle = new Rectangle(length, width);

        // Вывод результатов
        System.out.println("\nПараметры прямоугольника:");
        System.out.println("Длина: " + rectangle.getLength());
        System.out.println("Ширина: " + rectangle.getWidth());
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Периметр: " + rectangle.getPerimeter());

        scanner.close();
    }
}

// Класс Rectangle
class Rectangle {
    // Поля класса
    private double length;
    private double width;

    // Конструктор
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Геттер для длины
    public double getLength() {
        return length;
    }

    // Сеттер для длины
    public void setLength(double length) {
        this.length = length;
    }

    // Геттер для ширины
    public double getWidth() {
        return width;
    }

    // Сеттер для ширины
    public void setWidth(double width) {
        this.width = width;
    }

    // Метод для вычисления площади
    public double getArea() {
        return length * width;
    }

    // Метод для вычисления периметра
    public double getPerimeter() {
        return 2 * (length + width);
    }
}