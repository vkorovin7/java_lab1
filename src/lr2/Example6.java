package lr2;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Создание фигур ===");

        // --- Круг ---
        System.out.println("\nВведите радиус круга:");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);

        // --- Квадрат ---
        System.out.println("Введите сторону квадрата:");
        double sideSquare = scanner.nextDouble();
        Square square = new Square(sideSquare);

        // --- Треугольник ---
        System.out.println("Введите три стороны треугольника (через пробел или по очереди):");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        Triangle triangle = new Triangle(a, b, c);

        // Массив для демонстрации полиморфизма
        Shape[] shapes = {circle, square, triangle};

        System.out.println("\n=== Результаты ===");
        for (Shape shape : shapes) {
            System.out.println("Фигура: " + shape.getClass().getSimpleName());
            System.out.println("Площадь: " + String.format("%.2f", shape.getArea()));
            System.out.println("Периметр: " + String.format("%.2f", shape.getPerimeter()));
            System.out.println("-------------------");
        }

        scanner.close();
    }
}

// Интерфейс для геометрических фигур
interface Shape {
    double getArea();
    double getPerimeter();
}

// Класс Круг
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Класс Квадрат
class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}

// Класс Треугольник
class Triangle implements Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Геттеры
    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }

    // Сеттеры
    public void setA(double a) { this.a = a; }
    public void setB(double b) { this.b = b; }
    public void setC(double c) { this.c = c; }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        // Формула Герона
        double p = getPerimeter() / 2;
        // Проверка на существование треугольника внутри расчета
        if (p <= a || p <= b || p <= c) {
            return 0.0; // Треугольник не существует
        }
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
