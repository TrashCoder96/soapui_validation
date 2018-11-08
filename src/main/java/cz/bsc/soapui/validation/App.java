package cz.bsc.soapui.validation;

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

        SoapValidationUtils.validate(xmlInput, "C:\\Users\\itimofeev\\Desktop\\hc-soapui\\WSDL\\AccountWs05122017\\Accounts.xsd");
    }

}
