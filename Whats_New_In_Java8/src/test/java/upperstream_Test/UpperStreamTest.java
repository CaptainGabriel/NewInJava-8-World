package upperstream_Test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

import Patterns.Decorator_Pattern.NovoInputStream.UpperCaseInputStream;

public class UpperStreamTest {

  
  @Test
  public void transformFile() throws Exception {
    
    //decoration happens here! One on top of the other
    try (InputStream in = new UpperCaseInputStream(
                          new BufferedInputStream(
                          new FileInputStream(new File("testStream.txt"))))){
      int c = 0;
      String dontConcatLikeThis = "";
      while((c = in.read())!= -1) {
        dontConcatLikeThis += ((char)c);
      }
      String result = "THIS IS THE FILE USED TO TEST THE UPPERSTREAM CREATED IN THE PROJECT.\n";
      assertTrue(dontConcatLikeThis, result.equals(dontConcatLikeThis));
    }
  }
  
  
}
