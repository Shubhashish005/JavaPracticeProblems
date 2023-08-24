package info.java.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccuranceOfEachCharacter {

    public static void main(String[] args) {

        String str = "Ilovejavatechie";
        findOccuranceOfEachCHaracter(str);

        duplicateElemetsFromString(str);

        uniqueElementsInAString(str);

        firstNonRepeatElementFromString(str);
    }

    private static void firstNonRepeatElementFromString(String str) {
        String[] stringArray = str.split("");
        String nonRepeatElement = Arrays.stream(stringArray)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(val -> val.getValue() == 1)
                .findFirst()
                .get().getKey();
        System.out.println(nonRepeatElement);
    }

    private static void uniqueElementsInAString(String str) {
        String[] stringArray = str.split("");
        List<String> uniqueCharacters = Arrays.stream(stringArray)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(val -> val.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters);
    }

    private static void duplicateElemetsFromString(String str) {
        String[] stringArray = str.split("");
        List<String> duplicateCharacters = Arrays.stream(stringArray)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(val -> val.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(duplicateCharacters);
    }

    private static void findOccuranceOfEachCHaracter(String str) {
        String[] stringArray = str.split("");
        Map<String, Long> collect = Arrays.stream(stringArray)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }
}
