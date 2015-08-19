package DateAPI_Test;

import NewDateAPI.Person;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

/**
 * Created by pedrogabriel on 18-08-2015.
 */
public class DateTest {

    @Test
    public void creationOfLocalDateTest(){
        System.out.println("Test \'creationOfLocalDateTest\' started at " + LocalTime.now());

        LocalDate localdate = LocalDate.of(2010, Month.JULY, 10);
        Person p = new Person("Pedro", localdate);
        Instant t = Instant.now();

        assertTrue(t.compareTo(p.getInstantOfCreation()) == 0);
        assertTrue(p.getBirthdate().equals(localdate));
    }

    @Test
    public void instantOfCreationTest() throws InterruptedException {
        System.out.println("Test \'instantOfCreationTest\' started at " + LocalTime.now());

        //Month.JULY == Month.of(6); zero-based
        LocalDate localdate = LocalDate.of(2010, Month.JULY, 10);
        Person p = new Person("Pedro", localdate);

        Thread.sleep(1000); //otherwise, cpu works too fast n instants stay equal.

        LocalDate localdate2 = LocalDate.of(2012, Month.JULY, 10);
        Person p2 = new Person("Gabriel", localdate2);

        assertTrue(p2.getInstantOfCreation().isAfter(p.getInstantOfCreation()));
    }


    @Test
    public void differenceOfBirthdaysTest(){
        System.out.println("Test \'differenceOfBirthdaysTest\' started at " + LocalTime.now());

        LocalDate localdate = LocalDate.of(2010, Month.JULY, 10);
        Person p = new Person("Pedro", localdate);

        LocalDate localdate2 = LocalDate.of(2012, Month.JULY, 10);
        Person p2 = new Person("Gabriel", localdate2);

        //periodo - medida de tempo dentro de um intervalo
        LocalDate dateToTest = LocalDate.of(2015, Month.DECEMBER, 31);
        Period pTillToday  = Period.between(p.getBirthdate(), dateToTest);
        Period p2TillToday  = Period.between(p2.getBirthdate(), dateToTest);

        //nao tem em conta a data toda, apenas os anos.
        long pAmmountOfYears = pTillToday.get(ChronoUnit.YEARS);
        long p2AmmountOfYears = p2TillToday.get(ChronoUnit.YEARS);
        assertTrue((pAmmountOfYears - p2AmmountOfYears) > 0 );

        long pAmmountOfMonths = pTillToday.get(ChronoUnit.MONTHS);
        long p2AmmountOfMonths = p2TillToday.get(ChronoUnit.MONTHS);
        assertTrue(pAmmountOfMonths == p2AmmountOfMonths );


        long pAmmountOfDays = pTillToday.get(ChronoUnit.DAYS);
        long p2AmmountOfDays = p2TillToday.get(ChronoUnit.DAYS);
        assertTrue(pAmmountOfDays == p2AmmountOfDays);

    }
}
