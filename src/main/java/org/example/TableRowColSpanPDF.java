package org.example;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;

import java.util.Arrays;

public class TableRowColSpanPDF {

    public static void main(String[] args) throws Exception {
        String path = "C:/Users/johnhca/IdeaProjects/Itext/src/main/resources/temp/table.pdf";


        float comprimentoColunas[] = {100f, 100f, 100f};
        Table table = new Table(comprimentoColunas);

        table.addCell(new Cell().add("One"));
        table.addCell(new Cell().add("Two"));
        table.addCell(new Cell(2, 0).add("Three"));
        table.addCell(new Cell().add("Four"));
        table.addCell(new Cell().add("Five"));
        table.addCell(new Cell(0, 2).add("Six"));
        table.addCell(new Cell().add("Seven"));

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

}
