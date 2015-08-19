package Streams_Test;

import Streams.Types.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by pedrogabriel on 17-08-2015.
 */
public class PersonTest {

    static Person p ;

    @BeforeClass
    public static void InitTests(){
        p = new Person(0);
        p.createList();
    }


    @Test
    public void TestAmmountGeneratedByChainOfOperations(){
        /*
        Inside the method 'createList' two operations are chained
        in order to insert some data inside two collections.
        If everything went right, both have the same amount of elements.
        */
        assertTrue(p.getIds().size() == p.getPersons().size());
    }


    @Test
    public void Test_GetOnlyEvenIds(){
        List<Integer> toTest = Arrays.asList(0,2,4,6,8,10,12,14,16,18);

        List<Integer> onlyEven = p.getIds().stream().filter(id -> id % 2 == 0)
                                                    .collect(Collectors.toList());

        assertEquals(toTest, onlyEven);
    }

    @Test
    public void Test_GetOnlyOddIds(){
        List<Integer> toTest = Arrays.asList(1,3,5,7,9,11,13,15,17,19);

        List<Integer> onlyOdds = p.getIds().stream().filter(id -> id % 2 != 0)
                                                    .collect(Collectors.toList());

        assertEquals(toTest, onlyOdds);
    }

    @Test
    public void Test_Mapping_Fuctions(){
        List<Integer> toTest = Arrays.asList(1,3,5,7,9,11,13,15,17,19);
        List<Integer> toTest2 = Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14, 16, 18);
        List<List<Integer>> finalList = Arrays.asList(toTest, toTest2);

        //'col' will contain [10, 10]
        Collection<Integer> col = finalList.stream().map(List::size).collect(Collectors.toList());
        assertTrue(col.size() == 2);
        col.stream().forEach(elem -> System.out.print(elem + " ")); //10 10

        System.out.println(" ");

        //will contain 2 instances of stream
        Collection<Stream<Integer>> colOfStreams = finalList.stream().map(l -> l.stream()).collect(Collectors.toList());
        assertTrue(colOfStreams.size() == 2);
        colOfStreams.stream().forEach(elem -> System.out.print(elem + " ")); //object references

        System.out.println(" ");

        Collection<Integer> oneFlattedStream = finalList.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        assertTrue(oneFlattedStream.size() == 20);
        oneFlattedStream.stream().forEach(elem -> System.out.print(elem + " ")); //all together now
    }
}
