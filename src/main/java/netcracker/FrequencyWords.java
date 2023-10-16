package netcracker;

/*

Find most frequently occurring word(s) along with its frequency in given statement. If there is a tie in frequency, prefer the word that occurs first.
Example input: "Ram is employee of ABC company, RAM is from Pune, RAM! is good in java.“
Expected output: Word – Ram, Frequency - 3
 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyWords extends LinkedHashMap<String, Integer> {

    public static void main(String[] args) {

        String input = "Ram is employee of ABC company, RAM is from Pune, RAM! is good in java.";
        Map<String, Long> wordFrequency1 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        // Map<String , Integer> wordFrequency2 = new TreeMap<>(String::compareToIgnoreCase);
        List<String> insertionOrder = new ArrayList<>();

        String[] strArr = input.split(" ");
        List<String> stringArrayWithoutSpecialCharacters = Arrays.stream(strArr)
                .map(s -> s.replaceAll("[^a-zA-Z]", ""))
                .collect(Collectors.toList());

        Set<Map.Entry<String, Long>> entries = stringArrayWithoutSpecialCharacters.stream()
                .collect(Collectors.groupingBy(Function.identity(), () -> new TreeMap<>(String.CASE_INSENSITIVE_ORDER), Collectors.counting()))
                .entrySet();


        System.out.println(entries);
//        for(String str: stringArrayWithoutSpecialCharacters){
//            if(wordFrequency1.containsKey(str)){
//                wordFrequency1.put(str, wordFrequency1.get(str)+1);
//                insertionOrder.add(str);
//            }else{
//                wordFrequency1.put(str, 1);
//            }
//        }

        Long max = entries.stream().map(Map.Entry::getValue).max(Long::compare).get();
        System.out.println(max);
//        wordFrequency1.entrySet()
//                .stream()
//                .filter()
        List<Map.Entry<String, Long>> collect1 = wordFrequency1.entrySet().stream()
                // .filter(en -> en.getValue() >= max)
                .collect(Collectors.toList());
        System.out.println(collect1);


//        for(String s : str){
//            List<String> collect = Arrays.stream(s.split(""))
//                    .filter(c -> Character.isLetter(c.charAt(0)))
//
//                    .collect(Collectors.toList());
//            String newString = "";
//            for (String c:collect) {
//                newString = newString + c;
//            }
//
//            if(wordFrequency1.isEmpty()){
//                wordFrequency1.put(newString, 1);
//            }else {
//                Set<String> strings = wordFrequency1.keySet();
//                Boolean contains = false;
//
//                for(String s1 : strings){
//                    if(s1.equalsIgnoreCase(newString)){
//                        newString = s1;
//                        contains = true;
//                    }
//                }
//                if(contains){
//                    if(wordFrequency1.containsKey(newString)){
//                        wordFrequency1.put(newString, wordFrequency1.get(newString)+1);
//                    }else{
//                        wordFrequency1.put(newString, 1);
//                    }
//                }
//                else{
//                    wordFrequency1.put(newString, 1);
//                }
//            }
//        }
//        Map.Entry<String, Integer> stringIntegerEntry = wordFrequency1.entrySet()
//                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .findFirst()
//                .get();
//
//
//        System.out.println(stringIntegerEntry);
////
////        Arrays.stream(input.split(" "))
////                .map(s -> s.replaceAll("\\W", ""))
////                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
////                .entrySet()
////                .stream()
////                .
//

    }
}
