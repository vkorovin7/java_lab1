package lr2;

import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Банковский счет ===\n");

        // Ввод данных для создания счета
        System.out.println("Введите имя владельца счета:");
        String ownerName = scanner.nextLine();

        System.out.println("Введите номер счета:");
        String accountNumber = scanner.nextLine();

        System.out.println("Введите начальный баланс:");
        double initialBalance = scanner.nextDouble();

        // Создание объекта банковского счета
        BankAccount account = new BankAccount(ownerName, accountNumber, initialBalance);

        // Меню операций
        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("\n=== Меню операций ===");
            System.out.println("1. Пополнить счет (депозит)");
            System.out.println("2. Снять деньги");
            System.out.println("3. Проверить баланс");
            System.out.println("4. Вывести информацию о счете");
            System.out.println("5. Выход");
            System.out.print("Выберите операцию (1-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите сумму для пополнения: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Введите сумму для снятия: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Текущий баланс: " + account.getBalance() + " руб.");
                    break;

                case 4:
                    account.getAccountInfo();
                    break;

                case 5:
                    continueOperations = false;
                    System.out.println("До свидания!");
                    break;

                default:
                    System.out.println("Неверный выбор! Введите число от 1 до 5.");
            }
        }

        scanner.close();
    }
}

// Интерфейс для банковского счета
interface BankAccountInterface {
    void deposit(double amount);           // Пополнение счета
    void withdraw(double amount);          // Снятие денег
    double getBalance();                   // Получение текущего баланса
    void getAccountInfo();                 // Информация о счете
}

// Класс Банковский счет
class BankAccount implements BankAccountInterface {
    // Поля класса
    private String ownerName;
    private String accountNumber;
    private double balance;

    // Конструктор для создания нового счета
    public BankAccount(String ownerName, String accountNumber, double initialBalance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Геттеры
    public String getOwnerName() {
        return ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Сеттеры
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Реализация метода интерфейса - депозит
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Успешно пополнено на " + amount + " руб.");
            System.out.println("Текущий баланс: " + balance + " руб.");
        } else {
            System.out.println("Ошибка: сумма должна быть положительной!");
        }
    }

    // Реализация метода интерфейса - снятие денег
    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Успешно снято " + amount + " руб.");
                System.out.println("Текущий баланс: " + balance + " руб.");
            } else {
                System.out.println("Ошибка: недостаточно средств на счете!");
                System.out.println("Доступный баланс: " + balance + " руб.");
            }
        } else {
            System.out.println("Ошибка: сумма должна быть положительной!");
        }
    }

    // Реализация метода интерфейса - получение баланса
    @Override
    public double getBalance() {
        return balance;
    }

    // Реализация метода интерфейса - информация о счете
    @Override
    public void getAccountInfo() {
        System.out.println("\n=== Информация о счете ===");
        System.out.println("Владелец: " + ownerName);
        System.out.println("Номер счета: " + accountNumber);
        System.out.println("Баланс: " + balance + " руб.");
        System.out.println("==========================");
    }
}