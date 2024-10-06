package org.example.Solver;
import org.example.LineProcessor.LineProcessor;
import org.example.FileEditor.FileEditor;
import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;

public class Solver {

    private Vector<String> fileOne;
    private Vector<String> patterns;
    private Vector<Integer> firstEntered;
    private Vector<String> notFound;

    public void solveTask1(){
        FileEditor readFile = new FileEditor();

        String filePath ="C:\\Users\\Andrey\\IdeaProjects\\Lab4Task1\\src\\main\\java\\org\\example\\FileEditor\\input.txt";
        fileOne = readFile.ReadFile(filePath);

        filePath = "C:\\Users\\Andrey\\IdeaProjects\\Lab4Task1\\src\\main\\java\\org\\example\\FileEditor\\input2.txt";
        patterns = readFile.ReadFile(filePath);

        LineProcessor processor = new LineProcessor();
        Vector<Vector<String>> tagsFromFile = processor.findHTMLTags(fileOne);

        try(FileWriter writer = new FileWriter("Output1.txt")){
            writer.write("Каждая строка вывода показывает, какие теги всретились в данной строке. Теги отсортированы лексикографически:");

            for(int i = 0; i < tagsFromFile.size(); ++i){
                for(int j = 0; j < tagsFromFile.get(i).size(); ++j){
                    writer.write(tagsFromFile.get(i).get(j) + " ");
                }
                writer.write("\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void solveTask2(){
        LineProcessor processor = new LineProcessor();
        firstEntered = processor.findFirstPattern(fileOne, patterns);
        try(FileWriter writer = new FileWriter("Output2.txt")){
            writer.write("Номера строк, в которых впервые встречается один из шаблонов второго файла: ");
            for(int i = 0; i < firstEntered.size(); ++i){
                if(firstEntered.get(i) != -1){
                    writer.write(i + " ");
                }

            }
            writer.write("\n");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void solveTask3(){
        LineProcessor processor = new LineProcessor();
        notFound = processor.fragments(firstEntered, patterns);

        try(FileWriter writer = new FileWriter("Output3.txt")){
            writer.write("Ненайденные шаблоны: ");
            for(int i = 0; i < notFound.size(); ++i){
                writer.write(notFound.get(i) + "\n");
            }
            writer.write("\n");
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
