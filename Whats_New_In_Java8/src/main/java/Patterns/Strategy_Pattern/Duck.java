package Patterns.Strategy_Pattern;

import Patterns.Strategy_Pattern.FlyBehavior.FlyBehavior;
import Patterns.Strategy_Pattern.QuackBehavior.QuackBehavior;

/**
 * Didn't needed to be abstract. Just to make sure every duck has some sort of
 * presentation (display());
 * 
 * @author pgroot
 *
 */
public abstract class Duck {

	// behaviors depend on the instance.
	// is applied at runtime.
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;

	// methods inherited by other classes;

	public abstract void display();

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public final void swim() {
		System.out.println("All ducks float, at least !");
	}

	public void performQuack() {
		quackBehavior.quack(); //this is always the same. Just depends on the implementation of the interface.
	}

	public void performFly() {
		// this is always the same. Just depends on the implementation.
		flyBehavior.fly();
	}
}
