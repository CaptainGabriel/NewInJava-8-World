package Predicate_Test;

import Patterns.Predicate.Compare;
import Patterns.Predicate.MyFunctionalInterface;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

/**
 * Created by pedrogabriel on 17-08-2015.
 */
public class PredicateTest {

    @Test
    public void TestComparators(){
        final int i = 4, u = 4;
        Comparator<Integer> lambdaComp = Compare.compareTwoNumbers(); //using lambda
        Comparator<Integer> anonClassComp = Compare.compareTwoNumbersY(); //using anonymous class
        assertTrue(lambdaComp.compare(i, u) == anonClassComp.compare(i, u));
    }

    @Test
    public void TestIntegerToStringMethod(){
        Function<Integer,String> f = Compare.intToString();
        assertTrue(f.apply(2).equals("2"));
    }

    @Test
    public void TestFunctionalInterface(){
        //this is "wrong" since it is a Functional Interface
        //use lambda expressions instead

        /*MyFunctionalInterface mfi = new MyFunctionalInterface() {
            @Override
            public boolean checkPredicate(Predicate p) {
                return false;
            }
        };
        */

        MyFunctionalInterface mfi = (p, s) -> p.test(s); //Predicate::test
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        boolean checkTest = mfi.checkPredicate(isNotEmpty, "This String has content, therefore is not empty");
        assertTrue(checkTest);


    }
}
