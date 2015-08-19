package Patterns.Decorator_Pattern.condimentsDecorate;

import Patterns.Decorator_Pattern.mainType.Beverage;


/**
 * We are just decorating some beverage
 * by redefining its description.
 * 
 * @author Pedro Gabriel
 *
 */
public abstract class CondimentDecorator extends Beverage{

  public abstract String getDescription();
  
}
