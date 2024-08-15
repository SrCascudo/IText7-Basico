package org.example;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class FontPDF {

    public static void main(String[] args) throws Exception {
        String path = "C:/Users/johnhca/IdeaProjects/Itext/src/main/resources/temp/font.pdf";


        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

        Text text = new Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
                .setFont(font).setFontColor(Color.BLACK);

        Text textBold = new Text(""" 
                Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer 
                took a galley of type and scrambled it to make a type specimen book.
                """).setBold().setFontColor(Color.BLUE);

        Text textBold2 = new Text(""" 
                Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer 
                took a galley of type and scrambled it to make a type specimen book.
                """).setBold().setStrokeColor(Color.ORANGE);

        Text textItalic = new Text("""
                It has survived not only five centuries, but also the leap into electronic typesetting, remaining 
                essentially unchanged. 
                """).setFont(font).setItalic().setFontColor(Color.RED);

        Text textUnderline = new Text("""
                It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and 
                more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                """).setFont(font).setUnderline().setFontColor(Color.GREEN);

        Text textEmpty = new Text("""
                It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and 
                more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                """)
                .setFont(font)
                .setTextRenderingMode(PdfCanvasConstants.TextRenderingMode.STROKE)
                .setStrokeColor(Color.MAGENTA)
                .setStrokeWidth(0.5f);

        Paragraph paragraph = new Paragraph();
        paragraph
                .add(text)
                .add(textBold)
                .add(textBold2)
                .add(textItalic)
                .add(textUnderline)
                .add(textEmpty);

        document.add(paragraph);
        document.close();
    }

}
