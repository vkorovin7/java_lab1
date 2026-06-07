package lr8.task3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NewsParserNew{
    public static void main(String[] args) {
        try {
            parseAndSave();
        } catch (IOException e) {
            System.out.println("Ошибка при получении HTML-кода страницы: " + e.getMessage());
            System.out.println("Попытка переподключения...");
            try {
                parseAndSave();
            } catch (IOException e1) {
                System.out.println("Ошибка при повторном подключении к сайту: " + e1.getMessage());
                e1.printStackTrace();
            }
        }
    }

    private static void parseAndSave() throws IOException {
        Document doc = Jsoup.connect("https://news.ycombinator.com/")
                .userAgent("Mozilla/5.0")
                .timeout(5000)
                .get();

        Elements titles = doc.select("span.titleline > a");
        Elements scores = doc.select("span.score");

        BufferedWriter writer = new BufferedWriter(new FileWriter("news.txt"));

        for (int i = 0; i < Math.min(titles.size(), 10); i++) {
            Element titleElement = titles.get(i);
            String theme = titleElement.text();
            String link = titleElement.attr("href");

            String score = "";
            if (i < scores.size()) {
                score = scores.get(i).text();
            }

            System.out.println("Тема: " + theme);
            System.out.println("Ссылка: " + link);
            if (!score.isEmpty()) {
                System.out.println("Рейтинг: " + score);
            }
            System.out.println();

            writer.write("Тема: " + theme + "\n");
            writer.write("Ссылка: " + link + "\n");
            if (!score.isEmpty()) {
                writer.write("Рейтинг: " + score + "\n");
            }
            writer.write("\n");
        }

        writer.close();
        System.out.println("Данные успешно записаны в файл news.txt");
    }
}