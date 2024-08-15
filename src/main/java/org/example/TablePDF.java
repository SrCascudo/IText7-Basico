package org.example;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.border.*;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.util.Arrays;

public class TablePDF {

    public static void main(String[] args) throws Exception {
        String path = "C:/Users/johnhca/IdeaProjects/Itext/src/main/resources/temp/table.pdf";
        String imgSrc = "C:/Users/johnhca/IdeaProjects/Itext/src/main/resources/img/recompensa-luffy.jpg";

        // Imagem
        ImageData dataImage = ImageDataFactory.create(imgSrc);
        Image image = new Image(dataImage);
        image.setAutoScaleWidth(true);
        image.setAutoScaleHeight(true);
        image.setWidth(50f);

        // Bordas
        Border border = new SolidBorder(new DeviceRgb(200, 7, 4), 3);

        // Criação de Tabela
        String[] header = {"Item", "Qtd", "Categoria"};
        String[][] itens = {
                {"Manga", "10 KG", "Fruta"},
                {"Laranja", "70 KG", "Fruta"},
                {"Maçã", "50 KG", "Fruta"},
                {"Detergente", "10 Lt", "Limpeza"},
                {"Macarrão", "30 KG", "Massa"}
        };
        float comprimentoColunas[] = {200f, 50f, 100f};
        Table table = new Table(comprimentoColunas);

        table.addCell(new Cell().add(header[0]).setBackgroundColor(Color.LIGHT_GRAY));
        table.addCell(new Cell().add(header[1]).setBackgroundColor(new DeviceRgb(253,185,149)));
        table.addCell(new Cell().add(header[2]).setBackgroundColor(Color.LIGHT_GRAY));

        for (int i = 0; i < Arrays.stream(itens).count(); i++) {
            for(int j = 0; j < itens[i].length; j++) {
                table.addCell(new Cell().add(itens[i][j]).setBorder(border));
            }
        }

        table.addCell(new Cell().add("Luffy"));
        table.addCell(new Cell().add(image));
        table.addCell(new Cell().add("One Piece"));

//        Cell cell_11 = new Cell();
//        cell_11.add("Item");
//
//        table.addCell(cell_11);
//        table.addCell(new Cell().add("Qtd"));
//        table.addCell(new Cell().add("Categoria"));
//
//        table.addCell(new Cell().add("Manga"));
//        table.addCell(new Cell().add("2Kg"));
//        table.addCell(new Cell().add("Fruta"));
//
//        table.addCell(new Cell().add("Laranja"));
//        table.addCell(new Cell().add("5Kg"));
//        table.addCell(new Cell().add("Fruta"));

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        Document document = new Document(pdfDocument);
        document.add(table);
        document.close();
    }

}
