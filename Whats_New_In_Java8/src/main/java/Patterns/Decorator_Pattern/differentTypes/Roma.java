package Patterns.Decorator_Pattern.differentTypes;

import Patterns.Decorator_Pattern.mainType.Beverage;

public class Roma extends Beverage {

  public Roma() {
    description = "Roma.";
    howStrong = 8;
  }
  
  @Override
  public double cost() {
    return .49;
  }

}
