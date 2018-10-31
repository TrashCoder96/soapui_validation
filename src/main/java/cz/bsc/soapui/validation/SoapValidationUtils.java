package cz.bsc.soapui.validation;

import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.soap.SOAPBody;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

/**
 * Created by itimofeev on 29.10.2018.
 */
public class SoapValidationUtils {

    public static void validate(InputStream xml, File xsdFile) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(xsdFile);
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(xml));
    }

    public static void validate(SOAPBody body, String xsdUrl) throws Exception {
        File xsdFile = new File(xsdUrl);
        DOMImplementationLS domImplementationLS = (DOMImplementationLS)body.getOwnerDocument().getImplementation().getFeature("LS", "3.0");
        LSSerializer serializer = domImplementationLS.createLSSerializer();
        String str = serializer.writeToString(body.getChildNodes().item(1)).replace("UTF-16", "utf-8");
        InputStream stream = new ByteArrayInputStream(str.getBytes());
        validate(stream, xsdFile);
    }

}
