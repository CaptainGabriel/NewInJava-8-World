package Patterns.behavior_parameterization;

//Functional Interface
@FunctionalInterface
public interface AppleFilter<T> {

  public boolean evaluate(T other);
}
