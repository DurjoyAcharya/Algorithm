package CodingChallenge;

//Image to pdf Simple code
/**
 * da-durjoy@outlook.com
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExportPdfApp {
    private static final String OUTPUT_FOLDER="C:\\Users\\User\\Documents\\Documents";
    private static final String IMAGE_FOLDER="C:\\Users\\User\\Documents\\Documents";
    private static final String IMAGE_EXTENSION=".jpg";

    public static void main(String[] args) throws IOException, DocumentException {
        var ImageSourcePath= Path.of(IMAGE_FOLDER);
        var document=new Document(PageSize.A4,20.0f,20.0f,20.0f,150.0f);
        PdfWriter.getInstance(document,new FileOutputStream(OUTPUT_FOLDER+"//exports.pdf"));
        document.open();
        Files.walk(ImageSourcePath)
                .filter(path -> path.toString().endsWith(IMAGE_EXTENSION))
                .forEach(path -> addImageToDocument(document,path));
        document.close();
    }
    private static void addImageToDocument(Document document,Path path)
    {
        try{
            var image= Image.getInstance(path.toUri().toURL());
            document.setPageSize(image);
            document.newPage();
            image.setAbsolutePosition(0,0);
            document.add(image);
        }catch (IOException|DocumentException e){
            throw new RuntimeException(e);
        }
    }
}
