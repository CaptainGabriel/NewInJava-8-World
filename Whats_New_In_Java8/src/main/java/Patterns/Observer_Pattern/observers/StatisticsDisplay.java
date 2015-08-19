package Patterns.Observer_Pattern.observers;

import java.util.ArrayList;
import java.util.List;
import Patterns.Observer_Pattern.ISubject;

public class StatisticsDisplay implements IObserver, IDisplayElement{

  private List<Integer> temperatures;
  
  public StatisticsDisplay(ISubject subject) {
    subject.registerObserver(this);
    temperatures = new ArrayList<>();
  }
  
  
  @Override
  public void update(int temperature) {
    this.temperatures.add(temperature);
    display();
  }
  
  private String generateStatistics() {
    StringBuilder stb = new StringBuilder();
    int biggestTemp = 0, tmpVar = 0;
    for(int t : this.temperatures) {
      tmpVar+=t;
      biggestTemp = (t > biggestTemp) ? t : biggestTemp;
    };
    return stb.append("\nThe Hottest one -> ")
               .append(biggestTemp)
               .append("�C; \nThe median of temperatures was ")
               .append(tmpVar/temperatures.size())
               .append("�C.\n")
               .toString();
  }
  
  @Override
  public void display() {
    System.out.println(generateStatistics());
  }

}
