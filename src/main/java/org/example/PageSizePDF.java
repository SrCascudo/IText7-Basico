package org.example;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;

public class PageSizePDF {

    public static void main(String[] args) throws Exception {
        String path = "C:/Users/johnhca/IdeaProjects/Itext/src/main/resources/temp/PageSize.pdf";

        Rectangle myPageSize = new Rectangle(700, 1400);

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4); // Portrait
        pdfDocument.setDefaultPageSize(PageSize.A4.rotate()); // Landscape



//        Document document = new Document(pdfDocument, new PageSize(myPageSize));
        Document document = new Document(pdfDocument);

        Paragraph paragraph = new Paragraph();
        paragraph.add("John Helder");

        document.add(paragraph);
        document.close();
    }

}
