package TestNGFramework.TestNGMavenGitJenkins;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;



/**
 * Hello world!
 *
 */
public class App 
{
	
	static PDDocument pd=new PDDocument();
    public static void main( String[] args ) throws IOException 
    {
        System.out.println( "Hello World!" );
        
        fun("D:\\Desktop.png");
        fun("D:\\MyComputer.png");
        pd.close();
    }
    
    
    public static void fun(String path) throws IOException
    {
    	
    	
        PDPage page=new PDPage();
        pd.addPage(page);
        
        PDImageXObject image=PDImageXObject.createFromFile(path, pd);
        PDPageContentStream contents=new PDPageContentStream(pd,page);
        contents.drawImage(image, 0, 0);
        
        contents.close();
        pd.save(new File("D:\\pdfTesting.pdf"));
        
    }
}
