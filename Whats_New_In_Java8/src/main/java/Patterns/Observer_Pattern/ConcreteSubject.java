package Patterns.Observer_Pattern;

import java.util.ArrayList;
import java.util.List;
import Patterns.Observer_Pattern.observers.IObserver;

public class ConcreteSubject implements ISubject {
  //state
  private int temperature;
  
  //list of observers in order to notify each one of them in the future.
  List<IObserver> allTheObservers;

  //singleton
  private static ConcreteSubject instance;
  
  public static ISubject GetSubject() {
    return (instance == null)? new ConcreteSubject() : instance;
  }
  
  private ConcreteSubject() {
    allTheObservers = new ArrayList<IObserver>();
  }
  
  @Override
  public void registerObserver(IObserver obs) {
    allTheObservers.add(obs);
  }

  @Override
  public void removeObserver(IObserver obs) {
    allTheObservers.remove(obs);
  }

  @Override
  public void notifyObserver() {
    allTheObservers.forEach((observer)->observer.update(temperature));
  }

  public int getTemperature() {
    return temperature;
  }
  
  public void setTemperature(int temperature) {
    this.temperature = temperature;
    notifyObserver();
  }
  
}
