package CodingChallenge;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class Trail {

    private static final String OUTPUT="C:\\Users\\User\\Documents\\Documents\\Roll.pdf";
    private static Font catFont=new Font(Font.FontFamily.TIMES_ROMAN,18,Font.BOLD);
    private static Font redFont=new Font(Font.FontFamily.TIMES_ROMAN,18,Font.ITALIC, BaseColor.RED);
    private static Font colorFont=new Font(Font.FontFamily.HELVETICA,20,Font.BOLD,BaseColor.BLUE);

    public static void main(String[] args) throws IOException , DocumentException {

        var document=new Document(PageSize.A4,20.0f,20.0f,20.0f,150.0f);
        PdfWriter.getInstance(document,new FileOutputStream(OUTPUT));
        document.open();
     //   document.newPage();
        addMetaData(document);
        addTittlePage(document);
        document.close();
        System.out.println("Command Done");
    }
    private static void addMetaData(Document document)
    {
        document.addTitle("This My First Work");
        document.addAuthor("Durjoy Acharya");
        document.addSubject("da-durjoy@outlook.com");
        document.addCreator("Durjoy Acharya");

    }
    private static void addTittlePage(Document document) throws DocumentException,IOException
    {

        var preface=new Paragraph();
        var text= Files.readString(Path.of("C:\\Users\\User\\Documents\\Documents\\dox.txt"));
        preface.add(new Paragraph("This is Just a Header File",redFont));
        preface.add(new Paragraph(text,colorFont));
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("system","Durjoy Acharya") + ", " + new Date(),catFont));
        document.add(preface);
        document.newPage();
        preface.add("End Of The page");
        document.add(preface);
    }
}
