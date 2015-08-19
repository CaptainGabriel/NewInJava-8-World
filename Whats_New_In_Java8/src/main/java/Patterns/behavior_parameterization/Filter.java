package Patterns.behavior_parameterization;

//Functional Interface
/*
 * What can you do with functional interfaces? 
 * Lambda expressions let you provide the implementation 
 * of the abstract method of a 
 * functional interface directly in-line and treat the
 * whole expression as an instance of a functional interface
 */

@FunctionalInterface
public interface Filter<T> {

	public boolean eval(T other);
}
