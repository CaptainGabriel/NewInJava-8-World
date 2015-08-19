package Patterns.Decorator_Pattern.differentTypes;

import Patterns.Decorator_Pattern.mainType.Beverage;

public class HouseBlend extends Beverage {

  public HouseBlend() {
    description = "HouseBlend Coffee";
  }
  
  @Override
  public double cost() {
    return 0.50;
  }

}
