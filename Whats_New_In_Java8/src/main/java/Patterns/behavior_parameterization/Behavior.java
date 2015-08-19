package Patterns.behavior_parameterization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Behavior<T> {

	/*
	 * The implementation is way too dependent of the
	 * lonely string hardcoded inside our method.
	 * How about passing the color through the parameters ?
	 */
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> theGreenOnes = new ArrayList<>();
		if(inventory == null) return theGreenOnes;
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor()))
				theGreenOnes.add(apple);
		}
		return theGreenOnes;
	}

    /**
     *Version written using Java Streams API
     */
	public static List<Apple> _filterGreenApples(List<Apple> inventory) {
		return (inventory == null) ? null :
		                             inventory.stream()
											  .filter(apple -> "green".equals(apple.getColor()))
											  .collect(Collectors.toList());
	}

	/*
	 * Now we can pass any color to be compared but..
	 * What about when we want to compare another field ?
	 * Do we need to write a method for every situation ?
	 */
	public static List<Apple> filterGreenApples(List<Apple> inventory, String color) {
		List<Apple> theGreenOnes = new ArrayList<>();
		if(inventory == null) return theGreenOnes;
		for (Apple apple : inventory) {
			if (color.equals(apple.getColor()))
				theGreenOnes.add(apple);
		}
		return theGreenOnes;
	}

    /**
     *Version written using Java Streams API
     */
    public static List<Apple> _filterGreenApples(List<Apple> inventory, String color) {
        return (inventory == null) ? null :
                inventory.stream()
                        .filter(apple -> color.equals(apple.getColor()))
                        .collect(Collectors.toList());
    }

	// to compare other fields
	public static List<Apple> filterGreenApples(List<Apple> inventory, int weight) {
		List<Apple> theGreenOnes = new ArrayList<>();
		if(inventory == null) return theGreenOnes;
		for (Apple apple : inventory) {
			if (weight == apple.getWeight())
				theGreenOnes.add(apple);
		}
		return theGreenOnes;
	}

	// slightly more dynamic
	// We've parameterized the behavior of the filterApples method
	// yet we can do better..
	public static List<Apple> filterGreenApplesUsingPredicate(List<Apple> inventory, AppleFilter<Apple> filter) {
		List<Apple> theGreenOnes = new ArrayList<>();
		if(inventory == null) return theGreenOnes;
		for (Apple apple : inventory) {
			if (filter.evaluate(apple))
				theGreenOnes.add(apple);
		}
		return theGreenOnes;
	}

	// a more abstract way of doing things
	public static <T> List<T> filterAny(List<T> inventory, Filter<T> filter) {
		List<T> absThings = new ArrayList<>();
		if (inventory == null)
			return absThings;
		for (T t : inventory) {
			if (filter.eval(t))
				absThings.add(t);
		}
		return absThings;
	}

  
}
