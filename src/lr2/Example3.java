package lr2;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод текста для шифрования
        System.out.println("Введите текст для шифрования");
        String text = scanner.nextLine();

        // Ввод ключа
        System.out.println("Введите ключ");
        int key = scanner.nextInt();

        // Шифрование текста
        String encryptedText = caesarCipher(text, key);

        // Вывод зашифрованного текста
        System.out.println("Текст после преобразования: " + encryptedText);

        // Вопрос о обратном преобразовании
        System.out.println("Выполнить обратное преобразование? (y/n)");
        scanner.nextLine(); // Очистка буфера
        String answer = scanner.nextLine().toLowerCase();

        // Обработка ответа пользователя
        if (answer.equals("y")) {
            String decryptedText = caesarCipher(encryptedText, -key);
            System.out.println("Текст после обратного преобразования: " + decryptedText);
            System.out.println("До свидания!");
        } else if (answer.equals("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ");
        }

        scanner.close();
    }

    // Метод для шифрования/дешифрования текста
    public static String caesarCipher(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                // Смещение символа с учётом цикличности алфавита
                int shifted = (c - base + key) % 26;
                // Обработка отрицательных значений
                if (shifted < 0) {
                    shifted += 26;
                }
                result.append((char)(base + shifted));
            } else {
                // Небуквенные символы остаются без изменений
                result.append(c);
            }
        }

        return result.toString();
    }
}