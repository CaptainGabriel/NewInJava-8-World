package Strings_IO;


/**
 * Created by pedrogabriel on 19-08-2015.
 */
public class PersonIO {

    private String firstName;
    private String lastName;

    public PersonIO(String first, String last){
        firstName = first;
        lastName = last;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.join(", ", lastName, firstName);
    }
}
