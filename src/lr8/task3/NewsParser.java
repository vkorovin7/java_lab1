package lr8.task3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NewsParser {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://news.ycombinator.com/")
                    .userAgent("Mozilla/5.0")
                    .timeout(5000)
                    .get();

            Elements titles = doc.select("span.titleline > a");
            Elements scores = doc.select("span.score");

            for (int i = 0; i < Math.min(titles.size(), 10); i++) {
                System.out.println((i+1) + ". " + titles.get(i).text());
                if (!scores.isEmpty() && i < scores.size()) {
                    System.out.println("   Рейтинг: " + scores.get(i).text());
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}