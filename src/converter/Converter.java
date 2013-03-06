package converter;

/**
 *
 * @author istroganov
 */
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Converter {
    
    private final static String pathXML = "xml.xml";
   
    
    public static void main(String args[]) throws IOException {

//Входной файл, содержащий XML документ
        File input = new File(pathXML);
        SAXPars handler = new SAXPars();
        //SAX парсер
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
         
            parser.parse(input, handler);
//тут находим все элементы массива names и распечатываем по порядку
                 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
 DocxCreator.createDocx(handler.getList());
      
    }
     
}
