package Streams.Types;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by pedrogabriel on 17-08-2015.
 */
public class Person {

    private List<Person> persons;
    private List<Integer> ids;
    private int id;

    public Person(int i){
        id = i;
        persons = new ArrayList<>();
        ids = new ArrayList<>();
    }

    public int getId() { return id;}

    public List<Integer> getIds() { return ids;}

    public List<Person> getPersons() { return persons;}

    public void createList(){
        Consumer<Person> c1 = p -> persons.add(p) ;
        Consumer<Person> c2 = p -> ids.add(p.id) ;
        Consumer<Person> c3 = c1.andThen(c2);

        for (int i = 0; i < 20; i++)
            c3.accept(new Person(i));

    }


}
