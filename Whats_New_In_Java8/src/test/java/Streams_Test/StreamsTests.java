package Streams_Test;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import Streams.DishUtils;
import Streams.Types.Dish;

public class StreamsTests {
    static List<Dish> menu = new ArrayList<Dish>();
    static Dish d1, d2, d3, d4, d5, d6;

	static {
		d1 = new Dish("pork", false, 800, Dish.Type.MEAT);
		d2 = new Dish("beef", false, 700, Dish.Type.MEAT);
		d3 = new Dish("pizza", true, 550, Dish.Type.OTHER);
    	d4 = new Dish("french fries", true, 530, Dish.Type.OTHER);
		d5 = new Dish("season fruit", true, 120, Dish.Type.OTHER);
		d6 = new Dish("rice", true, 350, Dish.Type.OTHER);

		menu.add(d1);
		menu.add(d2);
		menu.add(d3);
		menu.add(d4);
		menu.add(d5);
		menu.add(d6);
		menu.add(new Dish("chicken", false, 400, Dish.Type.MEAT));
		menu.add(new Dish("prawns", false, 300, Dish.Type.FISH));
		menu.add(new Dish("salmon", false, 450, Dish.Type.FISH));
	}

	@Test
	public void dishes_above_550_calories() {
		assertTrue(DishUtils.findCaloricDishes(menu, 550).size() == 3);

		List<Dish> test = Arrays.asList(d3, d1, d2);

		DishUtils.findCaloricDishes(menu, 550).forEach((dish)->assertTrue(test.contains(dish)));
	}

	@Test
	public void dishes_are_mapped_correctly() {
		assertTrue(DishUtils
				.findCaloricDishes(menu, 550)
				.stream()
				.map(Dish::getType)
				.allMatch(
						(type) -> type == Dish.Type.MEAT || type == Dish.Type.OTHER));
	}

	@Test
	public void dishes_are_sorted_by_calories() {
		List<Dish> test = Arrays.asList(d1, d2, d3);
		List<Dish> res = DishUtils.findCaloricDishes(menu, 550)
								.stream()
								.sorted((dish1, dish2) -> dish2.getCalories()
										- dish1.getCalories()).collect(toList());
       for (int i = 0; i < 3; i++)
    	   assertTrue(test.get(i).equals(res.get(i)));

	}

	@Test
	public void dishes_that_are_vegetarian() {
		List<Dish> test = Arrays.asList(d3, d4, d5, d6);
		List<Dish> filteredList = DishUtils.filterVegetarianDishes(menu);

		// all types are 'Other'
		assertTrue(
			filteredList.stream().map(Dish::getType).allMatch((type) -> type == Dish.Type.OTHER));

		for (int i = 0; i < 4; i++) {
		  assertTrue(test.get(i).equals(filteredList.get(i)));
		}
	 }

}
