package global.goit.edu.eolimp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem7Tests {

    @Test
    public void testRomeToArabicMethodWorkOkToI() {

        //Given
        Map<String, Integer> testCases = new LinkedHashMap<>();

        //When
        testCases.put("I", 1);
        testCases.put("II", 2);
        testCases.put("III", 3);
        testCases.put("IV", 4);
        testCases.put("V", 5);
        testCases.put("VI", 6);
        testCases.put("VII", 7);
        testCases.put("VIII", 8);
        testCases.put("IX", 9);
        testCases.put("X", 10);

        //Then
        testCases.forEach((rome, expectedArabic) ->
            Assertions.assertEquals(
                    expectedArabic,
                    new Problem7().romeToArabic(rome)));
    }
}
