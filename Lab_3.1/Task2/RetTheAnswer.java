package org.example.RetTheAnswer;
import org.example.FileReader.FileReader;
import org.example.Solver.Solver;
import java.io.FileWriter;
import java.io.IOException;

public class RetTheAnswer {
    private String answer1;
    private String answer2;
    private String answer3;

    public void FirstPart(){
        FileReader reader = new FileReader();
        String filePath = "C:\\Users\\Andrey\\IdeaProjects\\Lab4Task2\\src\\main\\java\\org\\example\\RetTheAnswer\\input.txt";
        String fileInfo = reader.ReadFile(filePath);

        Solver solution = new Solver();
        answer1 = solution.deleteInBrackets(fileInfo);

        answer2 = solution.deleteInMoreThanTwo(fileInfo);

        answer3 = solution.deleteNoMeanZeroes(fileInfo);
        try(FileWriter writer = new FileWriter("output.txt")){
            writer.write("Строка с удаленными подстроками, которые стоят в скобках\n");
            writer.write(answer1 + '\n');

            writer.write("Строка с удаленными подстроками, которые стоят в скобках\n");
            writer.write(answer2 + '\n');

            writer.write("Строка с удаленными подстроками, которые стоят в скобках\n");
            writer.write(answer3 + '\n');

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
