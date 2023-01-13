package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static Streams.MapFilterReduce.intArray;
import static Streams.MapFilterReduce.strArray;

public class CollectCombineParallel {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.stream(intArray)
                .collect(Collectors.toList());
        Set<Integer> integerSet = Arrays.stream(intArray)
                .collect(Collectors.toSet());
        String sentence = Arrays.stream(strArray)
                .collect(Collectors.joining("--"));
        System.out.println(sentence);
        Long longWords = Arrays.stream(strArray)
                .filter(str -> str.length() > 4)
                .collect(Collectors.counting());
        Map<Integer, List<String>> wordLengthMap = Arrays.stream(strArray)
                .collect(Collectors.groupingBy(
                        (word) -> word.length()
                ));
        System.out.println(wordLengthMap);
        Map<Boolean, List<String>> slipMap = Arrays.stream(strArray)
                .collect(Collectors.partitioningBy(
                        (word) -> word.length() > 5
                ));
        System.out.println(slipMap);
    }
}
