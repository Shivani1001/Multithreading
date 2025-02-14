/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reflection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author shsahu
 */
public class StringBuilderDemo {
    public static void main(String args[]) throws IOException{
    long timeStart = System.currentTimeMillis();
    String result = readAlllinesFromFile();
    System.out.println(result);
    long delta1 = (System.currentTimeMillis() - timeStart);
    
    System.out.println("==================");
    
    timeStart = System.currentTimeMillis();
    result = readAllLinesWithStringBuilder();
    System.out.println(result);
    long delta2 = (System.currentTimeMillis() - timeStart);
    
    System.out.println("=============================");
		
    System.out.println("Time for opearation with String:\t" + delta1);
    System.out.println("Time for opearation with StringBuilder:\t" + delta2);
    }

    private static String readAlllinesFromFile() throws IOException {
     
        String resultString = "";
        List<String> allLines = Files.readAllLines(Paths.get("test_text.txt"));
        for(String line: allLines){
            resultString += line;
            resultString += System.lineSeparator();
        }
        return resultString;
                
   
    }

    private static String readAllLinesWithStringBuilder() throws IOException {
        StringBuilder sb = new StringBuilder();
        List<String> allLines = Files.readAllLines(Paths.get("test_text.txt"));
        for(String line: allLines){
           sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
        
    }
}
