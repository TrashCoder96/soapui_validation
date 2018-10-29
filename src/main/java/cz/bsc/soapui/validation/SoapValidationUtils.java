package cz.bsc.soapui.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
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

    public static void validate(String xml, String xsdUrl) throws IOException, SAXException {
        File xsdFile = new File(xsdUrl);
        InputStream xmlStream = new ByteArrayInputStream(xml.getBytes());
        validate(xmlStream, xsdFile);
    }

}
