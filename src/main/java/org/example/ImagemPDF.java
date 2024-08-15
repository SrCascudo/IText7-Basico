package org.example;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class ImagemPDF {

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        String path = "C:/Users/johnhca/IdeaProjects/Itext/src/main/resources/temp/imagem.pdf";
        String imgSrc = "C:/Users/johnhca/IdeaProjects/Itext/src/main/resources/img/recompensa-luffy.jpg";
        String txt = """
                Esse é um documento com imagem
                """;

        ImageData dataImage = ImageDataFactory.create(imgSrc);
        Image image = new Image(dataImage);

        PdfWriter pdfWriter = new PdfWriter(path);
        Paragraph paragraph = new Paragraph(txt);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        document.add(paragraph);
        document.add(image);
        document.close();
    }

}
