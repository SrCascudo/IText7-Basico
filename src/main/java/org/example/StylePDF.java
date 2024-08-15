package org.example;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;

import java.awt.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class StylePDF {

    public static void main(String[] args) throws Exception {
        String path = "C:/Users/johnhca/IdeaProjects/Itext/src/main/resources/temp/style.pdf";


        Style autor = new Style();
        autor
                .setFontColor(Color.BLUE)
                .setFontSize(24)
                .setItalic();

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);



        Document document = new Document(pdfDocument);

        Paragraph paragraph = new Paragraph();
        paragraph.add("John Helder").addStyle(autor);

        document.add(paragraph);
        document.close();
    }

}
