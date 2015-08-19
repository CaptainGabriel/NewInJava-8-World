package Patterns.Decorator_Pattern.differentTypes;

import Patterns.Decorator_Pattern.mainType.Beverage;

public class Cosi extends Beverage {

  public Cosi() {
    description = "Cosi";
  }
  
  @Override
  public double cost() {
    return .39;
  }

}
