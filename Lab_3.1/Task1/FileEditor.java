package org.example.FileEditor;
import java.io.*;
import java.io.FileReader;
import java.util.Vector;


public class FileEditor {

    public Vector<String> ReadFile(String path) {
        Vector<String> lineArray = new Vector<String>();
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            String line;
            lineArray = new Vector<>();
            while ((line = read.readLine()) != null) {
                lineArray.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineArray;
    }

}
