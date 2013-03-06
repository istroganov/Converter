package converter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xwpf.usermodel.*;

//import org.apache.poi.xwpf.usermodel.*;
/**
 *
 * @author istroganov
 */
public class DocxCreator {

    static void createDocx(List<Account> list) throws IOException {
        
XWPFDocument document = new XWPFDocument();

        for (Account acc : list) {

            XWPFParagraph paragraphOne = document.createParagraph();
            XWPFRun paragraphOneRunOne = paragraphOne.createRun();


            paragraphOne.setBorderBottom(Borders.SINGLE);
            paragraphOne.setBorderTop(Borders.SINGLE);
            paragraphOne.setBorderRight(Borders.SINGLE);
            paragraphOne.setBorderLeft(Borders.SINGLE);
            paragraphOne.setBorderBetween(Borders.SINGLE);
            paragraphOneRunOne.addBreak();
            paragraphOneRunOne.setText("ID пользователя: " + acc.id);
            paragraphOneRunOne.addBreak();
            paragraphOneRunOne.setText("Фамилия: " + acc.lastName);
            paragraphOneRunOne.addBreak();
            paragraphOneRunOne.setText("Имя: " + acc.firstName);
            paragraphOneRunOne.addBreak();
            paragraphOneRunOne.setText("Отчество: " + acc.middleName);
            paragraphOneRunOne.addBreak();
            paragraphOneRunOne.setText("Дата рождения: " + acc.middleName);
            paragraphOneRunOne.addBreak();
            paragraphOneRunOne.setText("Текущий баланс счета : " + acc.balance);
            paragraphOneRunOne.addBreak();
            paragraphOneRunOne.setText("Сумма последнего платежа : " + acc.lastPayment);
            paragraphOneRunOne.addBreak();
            paragraphOneRunOne.setText("Общая сумма затра : " + acc.totalAmount);
            paragraphOneRunOne.addBreak();
            paragraphOneRunOne.setText("Дата регистрации : " + acc.dateOfReg);
            paragraphOneRunOne.addBreak();

        }




        //перенос на новую строку


//            paragraphOneRunOne.setText("end");
//        XWPFRun paragraphOneRunTwo = paragraphOne.createRun();
//        paragraphOneRunTwo.setText("Run two!");
//        paragraphOneRunTwo.setText("Run 123!");
//        
//        paragraphOneRunTwo.setText("Run 345! \n");
//        paragraphOneRunTwo.setText("Run 678!");
//        paragraphOneRunTwo.setTextPosition(100);
// 
//        XWPFRun paragraphOneRunThree = paragraphOne.createRun();
//        paragraphOneRunThree.setStrike(true);
//        paragraphOneRunThree.setFontSize(20);
//        paragraphOneRunThree.setSubscript(VerticalAlign.SUBSCRIPT);
//        paragraphOneRunThree.setText(" More text in paragraph one...");
//       
//        paragraphOneRunThree.setText(" а тут йа, крведко, пыщ-пыщ...");
// 
//        XWPFParagraph paragraphTwo = document.createParagraph();
//        paragraphTwo.setAlignment(ParagraphAlignment.DISTRIBUTE);
//        paragraphTwo.setIndentationRight(200);
//        XWPFRun paragraphTwoRunOne = paragraphTwo.createRun();
//        paragraphTwoRunOne.setText("And this is paragraph two.");
//         paragraphTwoRunOne.setText("test1.");
//          paragraphTwoRunOne.setText("test2");
//           paragraphTwoRunOne.setText("test4");
        try {
            File b = new File("/123.docx");
            FileOutputStream a = new FileOutputStream(b);
            document.write(a);
            a.close();
            System.out.println("create good");

        } catch (java.io.FileNotFoundException e) {
            System.out.println("create fail");
        }
    }
}