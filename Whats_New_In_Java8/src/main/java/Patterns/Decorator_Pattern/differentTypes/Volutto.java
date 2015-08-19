package Patterns.Decorator_Pattern.differentTypes;

import Patterns.Decorator_Pattern.mainType.Beverage;

public class Volutto extends Beverage {

  public Volutto() {
    description = "Volutto";
    howStrong = 7;
  }
  
  @Override
  public double cost() {
    return .49;
  }

}
