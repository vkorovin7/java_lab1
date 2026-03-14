package lr2;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Работа с животными ===\n");

        // Создание собаки
        System.out.println("--- Создание собаки ---");
        System.out.print("Введите имя собаки: ");
        String dogName = scanner.nextLine();
        System.out.print("Введите возраст собаки: ");
        int dogAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите породу собаки: ");
        String dogBreed = scanner.nextLine();

        Dog dog = new Dog(dogName, dogAge, dogBreed);

        // Создание кошки
        System.out.println("\n--- Создание кошки ---");
        System.out.print("Введите имя кошки: ");
        String catName = scanner.nextLine();
        System.out.print("Введите возраст кошки: ");
        int catAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите тип корма для кошки: ");
        String catFood = scanner.nextLine();

        Cat cat = new Cat(catName, catAge, catFood);

        // Создание птицы
        System.out.println("\n--- Создание птицы ---");
        System.out.print("Введите имя птицы: ");
        String birdName = scanner.nextLine();
        System.out.print("Введите возраст птицы: ");
        int birdAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Может ли птица летать? (true/false): ");
        boolean canFly = scanner.nextBoolean();

        Bird bird = new Bird(birdName, birdAge, canFly);

        // Массив для демонстрации полиморфизма
        Animal[] animals = {dog, cat, bird};

        System.out.println("\n=== Информация о животных ===");
        for (Animal animal : animals) {
            System.out.println("\n" + animal.getClass().getSimpleName() + ":");
            animal.displayInfo();
            animal.makeSound();
            System.out.println("-------------------");
        }

        // Вызов уникальных методов подклассов
        System.out.println("\n=== Уникальные методы ===");
        dog.fetch();
        cat.purr();
        bird.fly();

        scanner.close();
    }
}

// Базовый класс Animal
class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void makeSound() {
        System.out.println(name + " издает звук.");
    }

    public void displayInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age + " лет");
    }
}

// Подкласс Dog
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Гав-гав!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Порода: " + breed);
    }

    // Уникальный метод для собаки
    public void fetch() {
        System.out.println(name + " приносит мячик!");
    }
}

// Подкласс Cat
class Cat extends Animal {
    private String foodType;

    public Cat(String name, int age, String foodType) {
        super(name, age);
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Мяу-мяу!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Тип корма: " + foodType);
    }

    // Уникальный метод для кошки
    public void purr() {
        System.out.println(name + " мурлычет от удовольствия!");
    }
}

// Подкласс Bird
class Bird extends Animal {
    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Чирик-чирик!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Может летать: " + (canFly ? "Да" : "Нет"));
    }

    // Уникальный метод для птицы
    public void fly() {
        if (canFly) {
            System.out.println(name + " летит в небе!");
        } else {
            System.out.println(name + " не может летать.");
        }
    }
}