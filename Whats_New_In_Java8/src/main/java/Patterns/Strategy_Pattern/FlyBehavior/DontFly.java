package Patterns.Strategy_Pattern.FlyBehavior;

public class DontFly implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I don\'t fly :( .. ");
	}

}
