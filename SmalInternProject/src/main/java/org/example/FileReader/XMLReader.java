package org.example.FileReader;

import org.example.ExpressionClass.Expression;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

public class XMLReader implements FileReader{
    @Override
    public void read(String filePath, Expression exp) {
        try{
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            exp.expression = root.getTextContent();

        }catch(Exception e){
            System.err.println("Error reading XML file: " + e.getMessage());
        }
    }
}
