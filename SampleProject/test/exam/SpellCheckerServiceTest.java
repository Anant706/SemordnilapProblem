package exam;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SpellCheckerServiceTest {
  
  @Test
  public void givenWordSpellCheckTrue() {
    SpellCheckerService spellCheckerService = new SpellCheckerService();
    
    assertTrue(spellCheckerService.spellChecker("mom"));
  }
  
  @Test
  public void givenWordSpellCheckFalse() {
    
    SpellCheckerService spellCheckerService = new SpellCheckerService();
    
    assertAll(() -> assertFalse(spellCheckerService.spellChecker("mummy")),
        () -> assertFalse(spellCheckerService.spellChecker("****")));
  }
  
  @Test
  public void givenWordSpellCheckThrowsException() throws IOException {
    String word = "mom";
    
    SpellCheckerService spellCheckerService = mock(SpellCheckerService.class);
    
    when(spellCheckerService.getResponse(word)).thenThrow(new IOException());
    when(spellCheckerService.spellChecker(word)).thenCallRealMethod();
    
    assertThrows(RuntimeException.class,
        () -> spellCheckerService.spellChecker(word));
  }
}