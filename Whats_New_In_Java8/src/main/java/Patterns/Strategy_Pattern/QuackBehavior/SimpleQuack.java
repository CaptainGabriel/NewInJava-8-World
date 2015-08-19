package Patterns.Strategy_Pattern.QuackBehavior;

public class SimpleQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack quack quack !!");
	}
}
