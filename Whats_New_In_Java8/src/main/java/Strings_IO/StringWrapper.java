package Strings_IO;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by pedrogabriel on 19-08-2015.
 */
public class StringWrapper {

    public static String joinTwoStrings(String str1, String str2){
        return String.join(" ", str1, str2);
    }

    public static String joinLotsOfStrings(String... str){
        StringJoiner strJoiner = new StringJoiner(", ", "{","}");
        for(String str1 : str){
           strJoiner.add(str1);
        }
        return strJoiner.toString();
    }

    public static String prettyJoinLotsOfStrings(List<String> str){
        StringJoiner strJoiner = new StringJoiner(",\n", "{\n","\n}");
        for(String str1 : str){
            strJoiner.add(str1);
        }
        return strJoiner.toString();
    }



}
