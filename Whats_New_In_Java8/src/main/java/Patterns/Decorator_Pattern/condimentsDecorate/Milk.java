package Patterns.Decorator_Pattern.condimentsDecorate;

import Patterns.Decorator_Pattern.mainType.Beverage;

import Patterns.Decorator_Pattern.condimentsDecorate.CondimentDecorator;
/**
 * Receives a beverage in order to decorate
 * with something, in this case, with milk.
 * 
 * @author Pedro Gabriel
 *
 */
public class Milk extends CondimentDecorator {

private Beverage toDecorate;
  
  public Milk(Beverage beverageToDecorate) {
    toDecorate = beverageToDecorate;
  }
  
  @Override
  public String getDescription() {
    return toDecorate.getDescription()+", with Milk";
  }

  @Override
  public double cost() {
    return .05 + toDecorate.cost();
  }
  
}
