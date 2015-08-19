package Patterns.Decorator_Pattern.NovoInputStream;

import java.io.IOException;
import java.io.InputStream;

public class UpperCaseInputStream extends InputStream {

  private InputStream in;
  public UpperCaseInputStream(InputStream in) {
   this.in = in;
  }
  
  @Override
  public int read() throws IOException {
    int c = in.read();
    return (c == -1 ? c : Character.toUpperCase(c));    
  }

  
}
