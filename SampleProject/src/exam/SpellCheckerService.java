package exam;

import java.io.*;
import java.net.*;
import java.util.*;

public class SpellCheckerService implements SpellCheckerProvider {
  
  @Override
  public boolean spellChecker(String word) {
    
    try {
      return getResponse(word) && getResponse(new StringBuilder(word).reverse().toString());
    } catch (IOException e) {
      throw new RuntimeException("Network Error");
    }
    
  }
  
  public boolean getResponse(String word) throws IOException {
    String spellCheckerURL = "http://agile.cs.uh.edu/spell?check=";
    
    var spellURL = spellCheckerURL + word;
    
    try (Scanner scanner = new Scanner(new URL(spellURL).openStream())) {
      return scanner.nextBoolean();
    }
  }
}
