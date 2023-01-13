package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapping {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] strArray = {"Hello", "functional", "programing", "is", "cool"};
        Function<Integer, Integer> doubleFunction = (x) -> {
            return x * 2;
        };
        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        List<Integer> evens = Arrays.stream(intArray)
                .filter(isEven)
                .collect(Collectors.toList());

        System.out.println(evens);

        List<Integer> collect = Arrays.stream(intArray)
                .map(doubleFunction)
                .collect(Collectors.toList());

        collect.stream()
                .forEach(System.out::println);

        Predicate<String> longer5Chars = (x) -> {
            return x.length() > 5;
        };
        List<String> strsLonger5 = Arrays.stream(strArray)
                .filter(longer5Chars)
                .collect(Collectors.toList());
        System.out.println(strsLonger5);

        Function<Integer, Predicate<String>>  createStrTester
                = (minLength) -> (str) -> str.length() > minLength;

        List<String> strsLonger4 = Arrays.stream(strArray)
                .filter(createStrTester.apply(4))
                .collect(Collectors.toList());
        System.out.println(strsLonger4);

    }
}
