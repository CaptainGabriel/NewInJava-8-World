package NewDateAPI;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;

public class Person{

    private String name;
    private LocalDate birthdate;
    private Instant instantOfCreation;
    private DayOfWeek dayOfBirthdate;

    public Person(String name, LocalDate birthdate){
        this.name = name;
        this.birthdate = birthdate;
        instantOfCreation = Instant.now();
        dayOfBirthdate = birthdate.getDayOfWeek();
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: "+name + " Birthdate: " + birthdate + "[" + dayOfBirthdate +"]";
    }

    public Instant getInstantOfCreation() {
        return instantOfCreation;
    }
}