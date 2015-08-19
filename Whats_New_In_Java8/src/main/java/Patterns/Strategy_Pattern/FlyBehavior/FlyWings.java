package Patterns.Strategy_Pattern.FlyBehavior;

public class FlyWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I'm flying with my wings !!");
	}

}
