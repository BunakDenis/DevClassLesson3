package global.goit.edu.eolimp;

import java.util.HashMap;
import java.util.Map;

public class Problem7 {

    public int romeToArabic(String rome) {

        int result = 0;

        Map<Character, Integer> romeArabicValues = new HashMap<>();
        romeArabicValues.put('I',1);
        romeArabicValues.put('V',5);
        romeArabicValues.put('X',10);


        char[] romeDigits = rome.toCharArray();

        for (int i = 0; i < romeDigits.length; i++) {
            char currentDigit = romeDigits[i];

            if (i == (romeDigits.length - 1)) {
                result += romeArabicValues.get(currentDigit);
            } else {
                char nextDigit = romeDigits[i+1];

                if (nextDigit > currentDigit) {
                    result += romeArabicValues.get(nextDigit) -
                              romeArabicValues.get(currentDigit);
                } else {
                    result += romeArabicValues.get(currentDigit) +
                              romeArabicValues.get(nextDigit);
                }
                i++;
            }
        }
        return result;
    }
}
