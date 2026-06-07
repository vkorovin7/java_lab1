package lr8.task1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import java.io.File;

public class CreateXMLFileNew {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);

            // Book 1
            Element book1 = doc.createElement("book");
            rootElement.appendChild(book1);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Преступление и наказание"));
            book1.appendChild(title1);

            Element author1 = doc.createElement("author");
            author1.appendChild(doc.createTextNode("Фёдор Достоевский"));
            book1.appendChild(author1);

            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("1866"));
            book1.appendChild(year1);

            // Book 2
            Element book2 = doc.createElement("book");
            rootElement.appendChild(book2);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Анна Каренина"));
            book2.appendChild(title2);

            Element author2 = doc.createElement("author");
            author2.appendChild(doc.createTextNode("Лев Толстой"));
            book2.appendChild(author2);

            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("1877"));
            book2.appendChild(year2);

            // Book 3
            Element book3 = doc.createElement("book");
            rootElement.appendChild(book3);

            Element title3 = doc.createElement("title");
            title3.appendChild(doc.createTextNode("Братья Карамазовы"));
            book3.appendChild(title3);

            Element author3 = doc.createElement("author");
            author3.appendChild(doc.createTextNode("Фёдор Достоевский"));
            book3.appendChild(author3);

            Element year3 = doc.createElement("year");
            year3.appendChild(doc.createTextNode("1880"));
            book3.appendChild(year3);

            // Book 4
            Element book4 = doc.createElement("book");
            rootElement.appendChild(book4);

            Element title4 = doc.createElement("title");
            title4.appendChild(doc.createTextNode("Обломов"));
            book4.appendChild(title4);

            Element author4 = doc.createElement("author");
            author4.appendChild(doc.createTextNode("Иван Гончаров"));
            book4.appendChild(author4);

            Element year4 = doc.createElement("year");
            year4.appendChild(doc.createTextNode("1859"));
            book4.appendChild(year4);

            // Book 5
            Element book5 = doc.createElement("book");
            rootElement.appendChild(book5);

            Element title5 = doc.createElement("title");
            title5.appendChild(doc.createTextNode("Евгений Онегин"));
            book5.appendChild(title5);

            Element author5 = doc.createElement("author");
            author5.appendChild(doc.createTextNode("Александр Пушкин"));
            book5.appendChild(author5);

            Element year5 = doc.createElement("year");
            year5.appendChild(doc.createTextNode("1833"));
            book5.appendChild(year5);

            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File("src/lr8/task1/ExampleNew.xml"));
            transformer.transform(source, result);
            System.out.println("XML-файл успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
