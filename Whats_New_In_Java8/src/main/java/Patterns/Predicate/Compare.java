package Patterns.Predicate;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Created by pedrogabriel on 17-08-2015.
 */
public class Compare {

    /**
     * @return comparator created by lambda expression (without the new keyword)
     */
    public static Comparator<Integer> compareTwoNumbers(){
        return (a, b) -> a - b;
        //return Integer::compare; Method References are another way of writing lambda expressions
    }

    /**
     *
     * @return comparator created by using an anounymous class (requires the new keyword)
     */
    public static Comparator<Integer> compareTwoNumbersY(){
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };
    }

    public static Function<Integer, String> intToString(){
        return (Integer i) -> "" + i;
    }

}
