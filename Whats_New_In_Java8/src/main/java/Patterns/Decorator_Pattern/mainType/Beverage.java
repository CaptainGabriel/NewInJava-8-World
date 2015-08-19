package Patterns.Decorator_Pattern.mainType;

public abstract class Beverage {

  protected String description = "Dont matter";
  protected int    howStrong   = 0;
  
  public String getDescription() {
    return description;
  }
  
  public abstract double cost();
  
  public int getHowStrong() {
    return howStrong;
  }
  
}
