package Patterns.Observer_Pattern;

import Patterns.Observer_Pattern.observers.IObserver;

public interface ISubject {

  
  public void registerObserver(IObserver obs);
  
  public void removeObserver(IObserver obs);
  
  public void notifyObserver();
  
}
