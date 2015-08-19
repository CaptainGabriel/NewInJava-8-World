package Patterns.Decorator_Pattern.condimentsDecorate;

import Patterns.Decorator_Pattern.mainType.Beverage;

public class Mocha extends CondimentDecorator{

  private Beverage toDecorate;
  
  public Mocha(Beverage beverageToDecorate) {
    toDecorate = beverageToDecorate;
  }

  @Override
  public String getDescription() {
    return "Mocha " + toDecorate.getDescription();
  }

  @Override
  public double cost() {
    return .25 + toDecorate.cost();
  }
  
}
