package by.bsuir.task71;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        Handler handler = new Handler(3);
        try {
            SAXParser parser = parserFactory.newSAXParser();
            parser.parse(new File("D:\\University\\JAVA_project\\OOP\\task7_1\\src\\by\\bsuir\\task71\\feed-test.xml"), handler);
            System.out.println(handler.getCountAll());
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
