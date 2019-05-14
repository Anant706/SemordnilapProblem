package exam;

import java.io.*;
import java.net.*;

public class SemordnilapApplication {
  
  private static String fileName = "resources/input.txt";
  
  public static void main(String[] args) {
    
    File file = getFileFromResource(fileName);
    String wordList = readFileContent(file);
    
    SemordnilapChecker semordnilapChecker = new SemordnilapChecker();
    int count = semordnilapChecker.checkSemordnilapWord(wordList);
    
    System.out.println("Number of Semordnilap is " + count + ".");
  }
  
  private static String readFileContent(File file) {
    StringBuilder wordList = new StringBuilder();
    
    try (FileReader reader = new FileReader(file);
         BufferedReader br = new BufferedReader(reader)) {
      String line;
      while ((line = br.readLine()) != null) {
        wordList.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return String.valueOf(wordList);
  }
  
  private static File getFileFromResource(String fileName) {
    ClassLoader classLoader = SemordnilapApplication.class.getClassLoader();
    
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("file is not found!");
    } else {
      return new File(resource.getFile());
    }
  }
}
