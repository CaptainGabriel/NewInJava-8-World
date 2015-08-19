package Streams;

import static java.util.stream.Collectors.toList;

import java.util.List;

import Streams.Types.Dish;
import Streams.Types.Dish.Type;

public class DishUtils {
    
    
  /**
   * Method that returns a collection with dishes above a certain level of calories.
   * 
   * @param source
   *          the list that contains all the elements
   * @param calories
   *          the value that compares to the ones in the elements
   * @return collection containing only those dishes above a certain value of calories.
   */
  public static List<Dish> findCaloricDishes(List<Dish> source, int calories) {
    return source.stream().filter((d) -> d.getCalories() >= calories).collect(toList());
  }

  /**
   * Method that returns a list of Type based upon mapping a given list of Dish objects.
   * 
   * @param menu
   *          Given list of dishes
   * @return List mapped by each Type of Dish class
   */
  public static List<Type> mapDishesByType(List<Dish> menu) {
    return menu.stream().map(Dish::getType).collect(toList());
  }

  /**
   * Method that filters the vegetarian dishes from a given menu.
   * 
   * @param menu
   *          Given list of dishes that contain or not the vegetarian dishes.
   * @return List of vegetarian Dishes.
   */
  public static List<Dish> filterVegetarianDishes(List<Dish> menu) {
    return menu.stream().filter(Dish::isVegetarian).collect(toList());
  }

}
