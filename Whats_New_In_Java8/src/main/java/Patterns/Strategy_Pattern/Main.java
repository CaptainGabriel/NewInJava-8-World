package Patterns.Strategy_Pattern;

import Patterns.Strategy_Pattern.FlyBehavior.DontFly;
import Patterns.Strategy_Pattern.FlyBehavior.FlyWings;
import Patterns.Strategy_Pattern.QuackBehavior.SimpleQuack;
import Patterns.Strategy_Pattern.QuackBehavior.YoungQuack;

public final class Main {

	public static void main(String[] args) {

		/*
		 * Duck duck = new Duck(); is not possible, obviously.
		 */
		Duck duck = new WildDuck();

		duck.setFlyBehavior(new FlyWings());
		duck.setQuackBehavior(new SimpleQuack());
		duck.display();
		duck.performFly();
		duck.performQuack();

		System.out.println("\n\n");

		// another duck..one that does not fly
		duck = new DecoyDuck();
		duck.setFlyBehavior(new DontFly());
		duck.setQuackBehavior(new YoungQuack());
		duck.display();
		duck.performFly();
		duck.performQuack();

	}

}
