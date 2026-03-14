package lr2;

import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод имени
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        // Ввод возраста
        System.out.println("Введите возраст:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Ввод пола
        System.out.println("Введите пол:");
        String gender = scanner.nextLine();

        // Создание объекта класса Person с введёнными данными
        Person person = new Person(name, age, gender);

        // Вывод информации о человеке
        System.out.println("\nИнформация о человеке:");
        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
        System.out.println("Пол: " + person.getGender());

        scanner.close();
    }
}

// Класс Person
class Person {
    // Поля класса (инкапсуляция - private)
    private String name;
    private int age;
    private String gender;

    // Конструктор для инициализации полей
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Сеттер для имени
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для возраста
    public int getAge() {
        return age;
    }

    // Сеттер для возраста
    public void setAge(int age) {
        this.age = age;
    }

    // Геттер для пола
    public String getGender() {
        return gender;
    }

    // Сеттер для пола
    public void setGender(String gender) {
        this.gender = gender;
    }
}
