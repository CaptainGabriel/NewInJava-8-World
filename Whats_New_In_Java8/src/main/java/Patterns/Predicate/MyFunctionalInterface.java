package Patterns.Predicate;

import java.util.function.Predicate;

@FunctionalInterface //not completely necessary but good practice
public interface MyFunctionalInterface{

    //methods with code inside interfaces - Default Methods
    default boolean isAboveZero(int i){
        return i > 0;
    }


    boolean checkPredicate(Predicate<String> p, String str);

    //inherit from Object class does not matter to make this interface
    //a valid functional interface
    boolean equals(Object obj);
}

