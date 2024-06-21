package global.goit.edu.eolimp;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(new Problem7().calculate(scanner.nextLine()));
    }

    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
    }

    public int romeToArabic(String rome) {

        int result = 0;

        Map<Character, Integer> romeArabicValues = new HashMap<>();
        romeArabicValues.put('I',1);
        romeArabicValues.put('V',5);
        romeArabicValues.put('X',10);
        romeArabicValues.put('L',50);
        romeArabicValues.put('C',100);
        romeArabicValues.put('D',500);
        romeArabicValues.put('M',1000);

        char[] romeDigits = rome.toCharArray();

        for (int i = 0; i < romeDigits.length; i++) {
            char currentDigit = romeDigits[i];
            int currentDigitValue = romeArabicValues.get(currentDigit);

            if (i == (romeDigits.length - 1)) {
                result += romeArabicValues.get(currentDigit);
            } else {
                char nextDigit = romeDigits[i+1];
                int nextDigitValue = romeArabicValues.get(nextDigit);

                if (nextDigitValue > currentDigitValue) {
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

    public String arabicToRome (int number) {

        Map<Integer, Character> arabicRomeValues = new HashMap<>();
        arabicRomeValues.put(1, 'I');
        arabicRomeValues.put(5, 'V');
        arabicRomeValues.put(10, 'X');
        arabicRomeValues.put(50, 'L');
        arabicRomeValues.put(100, 'C');
        arabicRomeValues.put(500, 'D');
        arabicRomeValues.put(1000, 'M');

        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public String calculate(String expression) {
/*        String[] romeNumbers = expression.split("\\+");

        int result = 0;
        for (String romeNumber : romeNumbers) {
            result += romeToArabic(romeNumber);
        }
        return arabicToRome(result);*/

        String[] romeNumbers = expression.split("\\+");

        int result = Arrays.stream(romeNumbers)
                .mapToInt(this::romeToArabic)
                .sum();

        return arabicToRome(result);
    }


}
