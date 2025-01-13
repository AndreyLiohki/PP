package filehandler;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class XMLFileHandler implements FileHandler{
    @Override
    public ArrayList<String> readFile(String filePath) {
        ArrayList<String> expressions = new ArrayList<>();

        try {
            FileProcessor fileProcessor = new FileProcessor();
            byte[] fileData = fileProcessor.processFile(filePath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new ByteArrayInputStream(fileData));

            NodeList nodeList = document.getElementsByTagName("expression");

            for (int i = 0; i < nodeList.getLength(); ++i) {
                expressions.add(nodeList.item(i).getTextContent().trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return expressions;
    }
}
