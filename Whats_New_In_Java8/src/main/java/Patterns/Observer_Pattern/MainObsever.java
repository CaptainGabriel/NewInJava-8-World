package Patterns.Observer_Pattern;

import java.util.Random;

import Patterns.Observer_Pattern.observers.ForecastDisplay;
import Patterns.Observer_Pattern.observers.StatisticsDisplay;

public class MainObsever {

  
  public static void main(String[] args) {
      ConcreteSubject subject = (ConcreteSubject) ConcreteSubject.GetSubject();
      
      ForecastDisplay forecast = new ForecastDisplay(subject);
      StatisticsDisplay stats = new StatisticsDisplay(subject);
      
      Random r = new Random();
      for (int i = 0; i < 20; i++) {
        subject.setTemperature(r.nextInt(50));
      }
  }
  
  
}
