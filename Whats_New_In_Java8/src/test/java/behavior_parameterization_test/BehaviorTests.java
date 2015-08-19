package behavior_parameterization_test;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Patterns.behavior_parameterization.*;

public class BehaviorTests {

	private final static List<Apple> allGreen;
	private final static List<Apple> allRed;

	private final static List<String> allStrs;

	static {
		allGreen = new ArrayList<>();
		allGreen.add(new Apple("green", 5));
		allGreen.add(new Apple("green", 2));
		allGreen.add(new Apple("green", 6));
		allGreen.add(new Apple("green", 4));

		allRed = new ArrayList<Apple>();

		allStrs = new ArrayList<String>();
		allStrs.add("Mission");
		allStrs.add("is not");
		allStrs.add("impossible!");

	}

	// implementation of predicates
	private class GreenApplePredicate implements AppleFilter {
		@Override
		public boolean evaluate(Object other) {
			if(!other.getClass().equals(Apple.class)) return false;
			Apple ap = (Apple)other;
			return "green".equals(ap.getColor());
		}
	}
	
	private class RedApplePredicate implements AppleFilter {
		@Override
		public boolean evaluate(Object other) {
			if(!other.getClass().equals(Apple.class)) return false;
			Apple ap = (Apple)other;
			return "red".equals(ap.getColor());
		}
	}

	@Test
	public void compare_only_green_apples() {
		final int result = 4;
		assertTrue(Behavior.filterGreenApples(allGreen).size() == result);
	}
	
	@Test
	public void fail_compare_only_green_apples() {
		final int result = 0;
		assertTrue(Behavior.filterGreenApples(allRed).size() == result);
	}

	@Test
	public void compare_only_green_apples_2() {
		final int result = 4;
		assertTrue(Behavior._filterGreenApples(allGreen).size() == result);
	}

	@Test
	public void fail_compare_only_green_apples_2() {
		final int result = 0;
		assertTrue(Behavior._filterGreenApples(allRed).size() == result);
	}

    @Test
	public void compare_only_green_apples_by_params() {
		final int result = 4;
		assertTrue(Behavior.filterGreenApples(allGreen, "green").size() == result);
	}

    @Test
    public void compare_only_green_apples_by_params_2() {
        final int result = 4;
        assertTrue(Behavior._filterGreenApples(allGreen, "green").size() == result);
    }

	@Test
	public void fail_compare_only_green_apples_by_params() {
		final int result = 0;
		assertTrue(Behavior.filterGreenApples(allGreen, "SomeOtherColor")
				.size() == result);
	}

	//testing the predicates
	@Test
	public void compare_green_apples_with_predicate(){
		final int result = 4;
		assertTrue(Behavior.filterGreenApplesUsingPredicate(allGreen, new GreenApplePredicate()).size() == result);
	}
	
	@Test
	public void fail_compare_green_apples_with_predicate(){
		final int result = 0;
		assertTrue(Behavior.filterGreenApplesUsingPredicate(allGreen, new RedApplePredicate()).size() == result);
	}
	
	//testing with anonymous class.
	@Test
	public void compare_using_anounyous_classs(){
		final int result = 4;
		assertTrue(Behavior.filterGreenApplesUsingPredicate(allGreen, new AppleFilter<Apple>() {
			@Override
			public boolean evaluate(Apple other) {
						return "green".equals(other.getColor());
			}
				}).size() == result);
	}
	
	@Test
	public void fail_compare_using_anounyous_classs(){
		final int result = 0;
		assertTrue(Behavior.filterGreenApplesUsingPredicate(allGreen, new AppleFilter<Apple>() {
			@Override
			public boolean evaluate(Apple other) {
				return "red".equals(other.getColor());
			}
				}).size() == result);
	}


	// testing with lambda expressions
	@Test
	public void compare_using_lambdas() {
		final int result = 4;
		assertTrue(Behavior.filterGreenApplesUsingPredicate(allGreen,
				(Apple apple) -> "green".equals(apple.getColor())).size() == result);
	}

	@Test
	public void fail_compare_using_lambdas(){
		final int result = 0;
		assertTrue(Behavior.filterGreenApplesUsingPredicate(allGreen, 
				(Apple apple) -> "yellow".equals(apple.getColor())).size() == result);
	}

	@Test
	public void compare_abstract_lists() {
		final int result = 3;
		assertTrue(Behavior.filterAny(allStrs, (str) -> !str.isEmpty()).size() == result);
	}

	@Test
	public void compare_with_assigment() {
		final int result = 3;
		Filter<String> f = str -> !str.isEmpty();  //needs to be Type-Check valid
													// String -> boolean
		assertTrue(Behavior.filterAny(allStrs, f).size() == result);
	}

}
