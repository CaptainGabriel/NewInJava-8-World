package String_IO_Test;

import Strings_IO.PersonIO;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by pedrogabriel on 19-08-2015.
 */
public class PersonIOTest {

    static PersonIO p1;
    static PersonIO p2;
    static PersonIO p3;
    static PersonIO p4;
    static PersonIO p5;


    @BeforeClass
    public static void InitObjs(){
        p1 =new PersonIO("Pedro", "Almeida");
        p2 =new PersonIO("Pedro", "Gustavo");
        p3 =new PersonIO("Pedro", "Conceicao");
        p4 =new PersonIO("Fabio", "Ferreira");
        p5 =new PersonIO("Elvis", "Coelho");
    }

    @Test
    public void compareLastNameTest(){

        List<PersonIO> people = Arrays.asList( p1, p2, p3, p4, p5);
        List<PersonIO> expectedList = Arrays.asList(p1, p5, p3, p4, p2);

        people.sort(Comparator.comparing(PersonIO::getLastName));

        assertEquals(expectedList, people);
    }

    @Test
    public void CompareFirstNameTest(){
        List<PersonIO> people = Arrays.asList( p1, p2, p3, p4, p5);
        List<PersonIO> expectedList = Arrays.asList(p5, p4, p1, p2, p3);

        people.sort(Comparator.comparing(PersonIO::getFirstName));

        assertEquals(expectedList, people);
    }

    @Test
    public void CompareLastThanFirstNameTest(){
        List<PersonIO> people = Arrays.asList( p1, p2, p3, p4, p5);
        List<PersonIO> expectedList = Arrays.asList(p5, p4, p1, p3, p2);

        people.sort(Comparator.comparing(PersonIO::getFirstName).thenComparing(PersonIO::getLastName));

        assertEquals(expectedList, people);
    }


}
