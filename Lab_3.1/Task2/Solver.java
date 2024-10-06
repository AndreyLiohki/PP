package org.example.Solver;

import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solver {

    public String deleteInBrackets(String line){
        String deletedInBrackets = line.toLowerCase();
        String example = "(\\(.*\\))";
        return deletedInBrackets.replaceAll(example, "").trim();
    }

    public String deleteInMoreThanTwo(String line){
        String regex = "(\\d{2})(\\d+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1));
        }

        matcher.appendTail(result);
        return result.toString();
    }

    public String deleteNoMeanZeroes(String line){
        String regex = "\\b0+(?=\\d)";
        return line.replaceAll(regex, "");
    }
}
