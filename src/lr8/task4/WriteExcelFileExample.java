package lr8.task4;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteExcelFileExample {
    public static void main(String[] args) {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("src/lr8/task4/example_new.xls"));
            WritableSheet sheet = workbook.createSheet("Товары", 0);

            // Заголовок
            sheet.addCell(new Label(0, 0, "Товар"));
            sheet.addCell(new Label(1, 0, "Характеристики"));
            sheet.addCell(new Label(2, 0, "Стоимость"));

            // Данные
            sheet.addCell(new Label(0, 1, "Книга"));
            sheet.addCell(new Label(1, 1, "Жанр: Научный, Автор: Коровин В.Д."));
            sheet.addCell(new jxl.write.Number(2, 1, 1499.0));

            sheet.addCell(new Label(0, 2, "Телефон"));
            sheet.addCell(new Label(1, 2, "Iphone 17 256gb"));
            sheet.addCell(new jxl.write.Number(2, 2, 78000.0));

            workbook.write();
            workbook.close();
            System.out.println("Данные записаны в файл: example_new.xls");
        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }
    }
}
