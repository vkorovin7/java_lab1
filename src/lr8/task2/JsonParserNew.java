package lr8.task2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class JsonParserNew {
    public static void main(String[] args) throws IOException, ParseException {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/lr8/task2/example-json-new.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Корневой элемент: " + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");
            for (Object o : jsonArray) {
                JSONObject book = (JSONObject) o;
                System.out.println("\nТекущий элемент: book");
                System.out.println("Название книги: " + book.get("title"));
                System.out.println("Автор: " + book.get("author"));
                System.out.println("Год издания: " + book.get("year"));
            }

            System.out.print("Хотите ли вы добавить новые книги? (Да или Нет): ");
            Scanner in = new Scanner(System.in);
            String answer = in.nextLine();
            String nameBook, author, year;
            if (answer.equals("Да")) {
                System.out.print("Введетие названии книги: ");
                nameBook = in.nextLine();
                System.out.print("Введетие имя автора: ");
                author = in.nextLine();
                System.out.print("Введетие год издания: ");
                year = in.nextLine();

                JSONObject newBook = new JSONObject();
                newBook.put("title", nameBook);
                newBook.put("author", author);
                newBook.put("year", year);
                jsonArray.add(newBook);
                jsonObject.put("books", jsonArray);
                try (FileWriter file = new FileWriter("src/lr8/task2/example-json-new.json")) {
                    file.write(jsonObject.toJSONString());
                    System.out.println("JSON-файл успешно дополнен!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (answer.equals("Нет")) {
                System.out.println("Пользователь не захотел дополнять файл");
            }

            System.out.print("Хотите ли вы найти книгу по автору и году? (Да или Нет): ");
            String answer1 = in.nextLine();
            if (answer1.equals("Да")) {
                int j = 0;
                String nameAuthor, yearForSearch;
                System.out.print("Введите имя автора: ");
                nameAuthor = in.nextLine();
                System.out.print("Введите год для поиска: ");
                yearForSearch = in.nextLine();
                for (Object o : jsonArray) {
                    JSONObject book = (JSONObject) o;
                    if (book.get("author").equals(nameAuthor) && book.get("year").equals(yearForSearch)) {
                        System.out.println("Книга найдена: " + book.get("title"));
                        j++;
                    }
                }
                if (j == 0) {
                    System.out.println("Такой книги нет");
                }
            } else if (answer1.equals("Нет")) {
                System.out.println("Пользователь отказался от поиска!");
            }

            System.out.print("Хотите ли вы удалить книгу? (Да или Нет): ");
            String answer2 = in.nextLine();
            if (answer2.equals("Да")) {
                String titleBook;
                System.out.print("Введите название книги: ");
                titleBook = in.nextLine();
                int j = 0;
                Iterator iterator = jsonArray.iterator();
                while (iterator.hasNext()) {
                    JSONObject book = (JSONObject) iterator.next();
                    if (titleBook.equals(book.get("title"))) {
                        iterator.remove();
                        j++;
                        System.out.println("Книга удалена");
                    }
                }
                jsonObject.put("books", jsonArray);
                try (FileWriter file = new FileWriter("src/lr8/task2/example-json-new.json")) {
                    file.write(jsonObject.toJSONString());
                    System.out.println("JSON-файл успешно дополнен!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (j == 0) {
                    System.out.println("Такой книги нет");
                }
            } else if (answer1.equals("Нет")) {
                System.out.println("Пользователь отказался от удаления!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}