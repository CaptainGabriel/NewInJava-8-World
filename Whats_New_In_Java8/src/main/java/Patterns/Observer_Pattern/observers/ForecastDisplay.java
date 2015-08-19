package Patterns.Observer_Pattern.observers;

import Patterns.Observer_Pattern.ISubject;

public class ForecastDisplay implements IObserver, IDisplayElement{

  private int temperature;
  private Conditions condition;
  
  public ForecastDisplay(ISubject toRegister) {
    toRegister.registerObserver(this);
  }
  
  
  @Override
  public void update(int temperature) {
    setCondition(temperature);
    setTemperature(temperature);
    display();
  }

  public void setCondition(int temperature) {
    condition = (temperature<10) ? Conditions.BAD : 
                (temperature > 10 && temperature<20) ? 
                    Conditions.NOT_GOOD : Conditions.GOOD;
  }
  
  public void setTemperature(int temperature) {
    this.temperature = temperature;
  }
  
  private enum Conditions{
    GOOD, NOT_GOOD, BAD;
  }

  @Override
  public void display() {
    System.out.printf("It's %d degrees outside, which is a %s day !",this.temperature, this.condition);
  }
  
  
}
