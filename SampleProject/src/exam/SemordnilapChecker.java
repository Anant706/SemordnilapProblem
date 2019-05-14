package exam;

import java.util.*;
import java.util.stream.*;

public class SemordnilapChecker {
  
  private SpellCheckerProvider spellCheckerProvider;
  
  public SemordnilapChecker() {
    spellCheckerProvider = new SpellCheckerService();
  }
  
  public int checkSemordnilapWord(String wholeParagraph) {
    
    int count = 0;
    
    List<String> wordList = Arrays.asList(wholeParagraph.split("\\s+"));
    
    List<String> collection = wordList.stream()
        .filter(s -> s.length() > 1)
        .collect(Collectors.toList());
    
    for (String word: collection)
      if (!word.equals(new StringBuilder(word).reverse().toString()) && spellCheckerProvider.spellChecker(word)) {
        count++;
      }
    
    return count;
  }
}
