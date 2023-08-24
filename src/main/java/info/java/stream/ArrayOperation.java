package info.java.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayOperation {

    public static void main(String[] args) {

        int arr[] = {5, 9, 11, 2, 8, 21, 1};
        String[] strArray = {"shubhashish", "kumar", "springboot", "microservice"};
        secondHighestNumberFromGivenArray(arr);
        longestStringFromGivenArray(strArray);
        elementsWhichStartWithOne(arr);
    }

    private static void elementsWhichStartWithOne(int[] arr) {
        List<String> startWithOneResult = Arrays.stream(arr)
                .boxed()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(startWithOneResult);
    }

    private static void longestStringFromGivenArray(String[] strArray) {
        String longetsString = Arrays.stream(strArray)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();

        System.out.println(longetsString);
    }

    private static void secondHighestNumberFromGivenArray(int[] arr) {
        Integer secondHighest = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(secondHighest);
    }
}
