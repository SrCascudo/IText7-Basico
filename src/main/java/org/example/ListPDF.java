package org.example;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class ListPDF {

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        String path = "C:/Users/johnhca/IdeaProjects/Itext/src/main/resources/temp/list.pdf";

        List list = new List();

        list.add("Java");
        list.add("Android");
        list.add("Kotlin");
        list.add("C");


        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        document.add(list);

        document.close();
    }

}
