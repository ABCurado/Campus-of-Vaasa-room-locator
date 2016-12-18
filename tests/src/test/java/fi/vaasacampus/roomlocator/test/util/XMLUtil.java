package fi.vaasacampus.roomlocator.test.util;

import org.w3c.css.sac.InputSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by niko on 17.12.2016.
 */
public class XMLUtil {
    private static Document doc;
    private static final String xmlUrl = "http://localhost/roomdb.xml";
    static {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(new URL(xmlUrl).openStream());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static Document getDoc () {
        return doc;
    }
}
