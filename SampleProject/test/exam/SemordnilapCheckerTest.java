package exam;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SemordnilapCheckerTest {
  
  private SemordnilapChecker semordnilapChecker;
  
  @BeforeEach
  void setUp() {
    semordnilapChecker = new SemordnilapChecker();
  }
  
  @Test
  public void canary() {
    assertTrue(true);
  }
  
  @Test
  public void checkSemordnilapWordIfFileIsEmpty() {
    
    assertEquals(0, semordnilapChecker.checkSemordnilapWord(""));
  }
  
  @Test
  public void checkSemordnilapWordIfFileHasSingleLetterWord() {
    
    assertEquals(0, semordnilapChecker.checkSemordnilapWord("a"));
  }
  
  @Test
  public void checkSemordnilapWordIfFileHasTwoLetterIncorrectWord() {
    
    assertEquals(0, semordnilapChecker.checkSemordnilapWord("ab"));
  }
  
  @Test
  public void checkSemordnilapWordIfFileHasFewCorrectWord() {
    
    assertEquals(0, semordnilapChecker.checkSemordnilapWord("some"));
  }
  
  @Test
  public void checkSemordnilapWordIfFileHasNoCorrectWord() {
    
    assertEquals(0, semordnilapChecker.checkSemordnilapWord("some things"));
  }
  
  @Test
  public void checkSemordnilapWordIfFileHasMoreCorrectWord() {
    
    assertEquals(2, semordnilapChecker.checkSemordnilapWord("some things are evil mom"));
  }
  
}