package lr8.task1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class XMLParserNew {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/lr8/task1/ExampleNew.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nТекущий элемент: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Название книги: " + element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Автор: " + element.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("Год издания: " + element.getElementsByTagName("year").item(0).getTextContent());
                }
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

                Element root = doc.getDocumentElement();
                Element newBook = doc.createElement("book");
                root.appendChild(newBook);

                Element title = doc.createElement("title");
                title.appendChild(doc.createTextNode(nameBook));
                newBook.appendChild(title);

                Element author1 = doc.createElement("author");
                author1.appendChild(doc.createTextNode(author));
                newBook.appendChild(author1);

                Element year1 = doc.createElement("year");
                year1.appendChild(doc.createTextNode(year));
                newBook.appendChild(year1);

                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("src/lr8/task1/exampleVar1.xml"));
                transformer.transform(source, result);
                System.out.println("XML-файл успешно дополнен!");
            } else if (answer.equals("Нет")) {
                System.out.println("Пользователь не захотел дополнять файл");
            }

            System.out.print("Хотите ли вы найти книгу по автору и году? (Да или Нет): ");
            String answer1 = in.nextLine();
            if (answer1.equals("Да")) {
                String nameAuthor, yearForSearch;
                System.out.print("Введите имя автора: ");
                nameAuthor = in.nextLine();
                System.out.print("Введите год для поиска: ");
                yearForSearch = in.nextLine();
                int j = 0;
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        if (element.getElementsByTagName("author")
                                .item(0)
                                .getTextContent()
                                .equals(nameAuthor)
                                &&
                                element
                                        .getElementsByTagName("year")
                                        .item(0)
                                        .getTextContent()
                                        .equals(yearForSearch)) {
                            System.out.println("Книга найдена! Имя книги: " + element
                                    .getElementsByTagName("title")
                                    .item(0)
                                    .getTextContent());
                            j++;
                        }
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
                doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                nodeList = doc.getElementsByTagName("book");
                String titleBook;
                System.out.print("Введите название книги: ");
                titleBook = in.nextLine();
                int j = 0;
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        if (element.getElementsByTagName("title").item(0).getTextContent().equals(titleBook)) {
                            Node parentNode = element.getParentNode();
                            parentNode.removeChild(element);
                            j++;
                        }
                    }
                }
                if (j == 0) {
                    System.out.println("Такой книги нет");
                }
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("src/lr8/task1/exampleVar1.xml"));
                transformer.transform(source, result);
                System.out.println("Книга удалена");
            } else if (answer1.equals("Нет")) {
                System.out.println("Отмена удаления");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}