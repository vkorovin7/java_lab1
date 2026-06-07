package lr8.task2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

public class JsonCreatorNew {
    public static void main(String[] args) {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        JSONObject book1 = new JSONObject();
        book1.put("title", "1984");
        book1.put("author", "Джордж Оруэлл");
        book1.put("year", 1949);

        JSONObject book2 = new JSONObject();
        book2.put("title", "Гарри Поттер и философский камень");
        book2.put("author", "Дж. К. Роулинг");
        book2.put("year", 1997);

        JSONObject book3 = new JSONObject();
        book3.put("title", "Улисс");
        book3.put("author", "Джеймс Джойс");
        book3.put("year", 1922);

        JSONObject book4 = new JSONObject();
        book4.put("title", "Портрет Дориана Грея");
        book4.put("author", "Оскар Уайльд");
        book4.put("year", 1890);

        JSONObject book5 = new JSONObject();
        book5.put("title", "Ловец в ржи");
        book5.put("author", "Джером Сэлинджер");
        book5.put("year", 1951);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        library.put("books", books);

        try (FileWriter file = new FileWriter("src/lr8/task2/example-json-new.json")) {
            file.write(library.toJSONString());
            System.out.println("JSON-файл успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
