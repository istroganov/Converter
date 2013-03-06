package converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXPars extends DefaultHandler {

    private List<Account> list = new ArrayList<Account>();
    Account item;
    boolean lastNameTag = false;
    boolean firstNameTag = false;
    boolean middleNameTag = false;
    boolean daytOfBirthTag = false;
    boolean balanceTag = false;
    boolean lastPaymentTag = false;
    boolean totalAmountTag = false;
    boolean dateOfRegTag = false;

    @Override
    public void startElement(String namespaceURI, String localName,
            String qName, Attributes atts) throws SAXException {
        if (qName.equals("Account")) {
            item = new Account();
            item.id = atts.getValue("id");
        }
        if (qName.equals("LastName")) {
            lastNameTag = true;
        }
        if (qName.equals("FirstName")) {
            firstNameTag = true;
        }
        if (qName.equals("MiddleName")) {
            middleNameTag = true;
        }
        if (qName.equals("DaytOfBirth")) {
            daytOfBirthTag = true;
        }
        if (qName.equals("Balance")) {
            balanceTag = true;
        }
        if (qName.equals("LastPayment")) {
            lastPaymentTag = true;
        }
        if (qName.equals("TotalAmount")) {
            totalAmountTag = true;
        }
        if (qName.equals("DateOfReg")) {
            dateOfRegTag = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (lastNameTag) {
            item.lastName = new String(ch, start, length);
        }
        if (firstNameTag) {
            item.firstName = new String(ch, start, length);
        }
        if (middleNameTag) {
            item.middleName = new String(ch, start, length);
        }
        if (daytOfBirthTag) {
            try {
                String date_time = new String(ch, start, length);
                SimpleDateFormat dateFrom = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFrom.parse(date_time);
                SimpleDateFormat dateTo = new SimpleDateFormat("dd.MM.yyyy");

                item.daytOfBirth = dateTo.format(date);
            } catch (ParseException ex) {
                Logger.getLogger(SAXPars.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (balanceTag) {
            String s = new String(ch, start, length);
            item.balance = Integer.parseInt(s);
        }
        if (lastPaymentTag) {
            String s = new String(ch, start, length);
            item.lastPayment = Integer.parseInt(s);
        }
        if (totalAmountTag) {
            String s = new String(ch, start, length);
            item.totalAmount = Integer.parseInt(s);
        }
        if (dateOfRegTag) {
            try {
                String date_time = new String(ch, start, length);
                SimpleDateFormat dateFrom = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFrom.parse(date_time);
                SimpleDateFormat dateTo = new SimpleDateFormat("dd.MM.yyyy");

                item.dateOfReg = dateTo.format(date);
            } catch (ParseException ex) {
                Logger.getLogger(SAXPars.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {

          
        lastNameTag = false;
        firstNameTag = false;
        middleNameTag = false;
        daytOfBirthTag = false;
        balanceTag = false;
        lastPaymentTag = false;
        totalAmountTag = false;
        dateOfRegTag = false;
          if (qName.equals("Account")) {
            list.add(item);
        }
        
    }

    public List<Account> getList() {
        return list;
    }
}