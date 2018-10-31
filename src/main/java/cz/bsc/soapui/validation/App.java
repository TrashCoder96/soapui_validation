package cz.bsc.soapui.validation;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;

/**
 * Created by itimofeev on 29.10.2018.
 */
public class App {

    public static void main(String[] args) throws Exception {

        String xmlInput =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:acc=\"http://ibs.homecredit.ru/accounts\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "      <acc:getAccounts>\n" +
                        "         <acc:CUID>346456</acc:CUID>\n" +
                        "      </acc:getAccounts>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";

        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage(
                new MimeHeaders(),
                new ByteArrayInputStream(xmlInput.getBytes()));
        SOAPBody body = message.getSOAPBody();

        SoapValidationUtils.validate(body, "C:\\Users\\itimofeev\\Desktop\\hc-soapui\\WSDL\\AccountWs05122017\\Accounts.xsd");
    }

}
