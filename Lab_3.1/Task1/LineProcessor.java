package org.example.LineProcessor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Set;

public class LineProcessor {
    public Vector<Vector<String>> findHTMLTags(Vector<String> lines){
        String regexPattern= "<[^>]+>";
        Pattern pattern = Pattern.compile(regexPattern);

        Vector<Vector<String>> answerForLines = new Vector<>();

        for(int i = 0; i < lines.size(); ++i){
            Matcher matcher = pattern.matcher((lines.get(i)));

            Set<String> tags = new HashSet<>();

            while(matcher.find()){
                tags.add(matcher.group());
            }

            Vector<String> currentLineTags = new Vector<>();

            for(String a: tags){
                currentLineTags.add(a);
            }
            Collections.sort(currentLineTags);
            answerForLines.add(currentLineTags);
        }


        return answerForLines;
    }

    public Vector<Integer> findFirstPattern(Vector<String> lines, Vector<String> secondFileLines){
        Vector<Integer> lineIndexes = new Vector<>();
        Vector<String> editedLines = new Vector<>();
        String regexPattern= "<[^>]+>";
        Pattern pattern = Pattern.compile(regexPattern);
        for(int i = 0; i < lines.size(); ++i){
            String result = lines.get(i).replaceAll(regexPattern, "");
            editedLines.add(result);
        }
        for(int i = 0; i < secondFileLines.size(); ++i){
            boolean flag = true;
            for(int j = 0; j < editedLines.size(); ++j){
                boolean isSubstring = editedLines.get(j).contains(secondFileLines.get(i));
                if(isSubstring){
                    lineIndexes.add(j);
                    flag = !flag;
                    secondFileLines.remove(i);
                    break;
                }
            }
            if(flag){
                lineIndexes.add(-1);
            }
        }
        return lineIndexes;
    }

    public Vector<String> fragments(Vector<Integer> lineIndexes, Vector<String> secondFile){
        Vector<String> frags = new Vector<>();
        for(int i = 0; i < lineIndexes.size(); ++i){
            if(lineIndexes.get(i) == -1){
                frags.add(secondFile.get(i));
            }
        }
        return frags;
    }
}
