package Patterns.Decorator_Pattern.differentTypes;

import Patterns.Decorator_Pattern.mainType.Beverage;

public class Ristretto extends Beverage {

  public Ristretto() {
    description = "Ristretto";
    howStrong = 10;
  }
  @Override
  public double cost() {
     return .39; 
  }

  
  
  
}
