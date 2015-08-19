package Patterns.Decorator_Pattern.condimentsDecorate;

import Patterns.Decorator_Pattern.mainType.Beverage;

public class Whip extends CondimentDecorator {

  private Beverage toDecorate;
  
  public Whip(Beverage beverageToDecorate) {
    toDecorate = beverageToDecorate;
  }
  
  @Override
  public String getDescription() {
    return toDecorate.getDescription() + ", whith Whip";
  }

  @Override
  public double cost() {
    return .20 + toDecorate.cost();
  }

}
