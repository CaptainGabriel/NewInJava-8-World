package String_IO_Test;

import Strings_IO.StringWrapper;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by pedrogabriel on 19-08-2015.
 */
public class StringWrapperTest {

    @Test
    public void concatTwoStringsTest(){
        String one = "Hello", two = "World";
        String expectedString = "Hello World";
        String obtainedString = StringWrapper.joinTwoStrings(one, two);

        assertTrue(obtainedString.equals(expectedString));
    }

    @Test
    public void JoinVariousStringsTest(){
        String[] strArray = {"Git", "Hub", "Reddit", "Java", "Bit", "Bucket"};
        String expected = "{Git, Hub, Reddit, Java, Bit, Bucket}";
        assertEquals(expected, StringWrapper.joinLotsOfStrings(strArray));
    }

    @Test
    public void PrettyPrintAllDirectoriesInsidePatternsFolderTest(){
        String expected ="{\n" +
                "Decorator_Pattern,\n" +
                "Iterator_Pattern,\n" +
                "Observer_Pattern,\n" +
                "Predicate,\n" +
                "State_Pattern,\n" +
                "Strategy_Pattern,\n" +
                "behavior_parameterization\n" +
                "}";

        String obtained = "";

        Path path = Paths.get("src","main", "java", "Patterns");
        try(Stream<Path> p = Files.list(path)){

            List<String> list = new ArrayList<>();
            p.filter(pathh -> pathh.toFile().isDirectory())
                    .sorted()
                    .forEach(pathh -> list.add(pathh.toFile().getName()));

            obtained = StringWrapper.prettyJoinLotsOfStrings(list);

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expected, obtained);
    }
}
