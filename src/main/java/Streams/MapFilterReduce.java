package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapFilterReduce {
    public static Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static String[] strArray = {"Hello", "functional", "programing", "is", "cool"};
    public static void main(String[] args) {

        Function<Integer, Integer> doubleFunction = (x) -> {
            return x * 2;
        };
        Predicate<Integer> isEven = (x) -> x % 2 == 0;

        List<Integer> evens = Arrays.stream(intArray)
                .filter(isEven)
                .collect(Collectors.toList());

        System.out.println("All evens: " +  evens);

        Function<Integer, Predicate<Integer>> isDivisibleByDivisor
                = (divisor) -> (inboundInt) -> inboundInt % divisor == 0;
        List<Integer> intsDivisibleBy3 = Arrays.stream(intArray)
                .filter(isDivisibleByDivisor.apply(3))
                .collect(Collectors.toList());
        System.out.println("All ints divisible by 3: " + intsDivisibleBy3);

        List<Integer> intsDivisibleBy5 = Arrays.stream(intArray)
                .filter(isDivisibleByDivisor.apply(5))
                .collect(Collectors.toList());
        System.out.println("All ints divisible by 5: " + intsDivisibleBy5);

        List<Integer> collect = Arrays.stream(intArray)
                .map(doubleFunction)
                .collect(Collectors.toList());

        collect.stream()
                .forEach(System.out::println);

        Predicate<String> longer5Chars = (x) -> x.length() > 5;
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

        Integer sum = Arrays.stream(intArray)
                .reduce((x, y) -> x + y)
                .get();
        System.out.println("Easy sum: " + sum);

        BinaryOperator<Integer> getSum = (accumulator, x) -> {
            Integer result = accumulator + x;
            System.out.println(("Acc: " + accumulator + ", x: " + x + ", result: " + result));
            return result;
        };

        Integer complexSum = Arrays.stream(intArray)
                .filter(isDivisibleByDivisor.apply(3))
                .reduce(10, getSum);
        System.out.println("Complex sum: " + complexSum);
    }
}
