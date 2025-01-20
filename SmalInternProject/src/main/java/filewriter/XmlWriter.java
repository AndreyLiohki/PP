package filewriter;

import objects.ExpressionEvaluationResult;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class XmlWriter implements ResultWriter {
    @Override
    public void writeToFile(ArrayList<ExpressionEvaluationResult> results, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(ExpressionEvaluationResult[].class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(results.toArray(new ExpressionEvaluationResult[0]), new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}