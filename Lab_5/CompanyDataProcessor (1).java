package org.example;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper; 
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CompanyDataProcessor {

    static class Company {
        String name;
        String shortTitle;
        String dateUpdate;
        String address;
        String dateFoundation;
        String countEmployees;
        String auditor;
        String phone;
        String email;
        String branch;
        String activity;
        String internetAddress;

        
        public Company(String[] fields) {
            this.name = fields[0];
            this.shortTitle = fields[1];
            this.dateUpdate = fields[2];
            this.address = fields[3];
            this.dateFoundation = fields[4];
            this.countEmployees = fields[5];
            this.auditor = fields[6];
            this.phone = fields[7];
            this.email = fields[8];
            this.branch = fields[9];
            this.activity = fields[10];
            this.internetAddress = fields[11];
        }
    }

    private List<Company> companies = new ArrayList<>();
    private static final String LOG_FILE = "logfile.txt";

    public void readData(String inputFile) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        for (String line : lines) {
            String[] fields = line.split(";");
            companies.add(new Company(fields));
        }
    }

    public List<Company> findByShortTitle(String shortTitle) {
        logQuery("Search by short title: " + shortTitle);
        return filterCompanies(company -> company.shortTitle.equalsIgnoreCase(shortTitle));
    }

    public List<Company> findByBranch(String branch) {
        logQuery("Search by branch: " + branch);
        return filterCompanies(company -> company.branch.equalsIgnoreCase(branch));
    }

    public List<Company> findByActivity(String activity) {
        logQuery("Search by activity: " + activity);
        return filterCompanies(company -> company.activity.equalsIgnoreCase(activity));
    }

    public List<Company> findByFoundationDate(LocalDate from, LocalDate to) {
        logQuery("Search by foundation date from " + from + " to " + to);
        return filterCompanies(company -> {
            LocalDate foundationDate = LocalDate.parse(company.dateFoundation);
            return !foundationDate.isBefore(from) && !foundationDate.isAfter(to);
        });
    }

    public List<Company> findByEmployeeCount(int from, int to) {
        logQuery("Search by employee count from " + from + " to " + to);
        return filterCompanies(company -> {
            int count = Integer.parseInt(company.countEmployees);
            return count >= from && count <= to;
        });
    }

    private List<Company> filterCompanies(java.util.function.Predicate<Company> predicate) {
        List<Company> result = new ArrayList<>();
        for (Company company : companies) {
            if (predicate.test(company)) {
                result.add(company);
            }
        }
        return result;
    }

    private void logQuery(String query) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " - " + query);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToJson(List<Company> companies, String outputFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(outputFile), companies);
    }

    public void writeToXml(List<Company> companies, String outputFile) throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element rootElement = doc.createElement("Companies");
        doc.appendChild(rootElement);

        for (Company company : companies) {
            Element companyElement = doc.createElement("Company");
            rootElement.appendChild(companyElement);

            createElement(doc, companyElement, "Name", company.name);
            createElement(doc, companyElement, "ShortTitle", company.shortTitle);
            createElement(doc, companyElement, "DateUpdate", company.dateUpdate);
            createElement(doc, companyElement, "Address", company.address);
            createElement(doc, companyElement, "DateFoundation", company.dateFoundation);
            createElement(doc, companyElement, "CountEmployees", company.countEmployees);
            createElement(doc, companyElement, "Auditor", company.auditor);
            createElement(doc, companyElement, "Phone", company.phone);
            createElement(doc, companyElement, "Email", company.email);
            createElement(doc, companyElement, "Branch", company.branch);
            createElement(doc, companyElement, "Activity", company.activity);
            createElement(doc, companyElement, "InternetAddress", company.internetAddress);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(outputFile));
        transformer.transform(source, result);
    }

    private void createElement(Document doc, Element parent, String name, String value) {
        Element element = doc.createElement(name);
        element.appendChild(doc.createTextNode(value));
        parent.appendChild(element);
    }

    public static void main(String[] args) {
        try {
            CompanyDataProcessor processor = new CompanyDataProcessor();
            processor.readData("input.csv");

          
            List<Company> result1 = processor.findByShortTitle("ExampleTitle");
            List<Company> result2 = processor.findByBranch("IT");
            List<Company> result3 = processor.findByActivity("Development");
            List<Company> result4 = processor.findByFoundationDate(LocalDate.of(2000, 1, 1), LocalDate.of(2020, 12, 31));
            List<Company> result5 = processor.findByEmployeeCount(50, 200);

           
            processor.writeToJson(result1, "output.json");
            processor.writeToXml(result1, "output.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}