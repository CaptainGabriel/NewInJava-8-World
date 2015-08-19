package Patterns.Strategy_Pattern.QuackBehavior;


public class YoungQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("Quacky Quacky !!");
	}

}
