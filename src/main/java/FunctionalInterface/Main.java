package FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class Main {
    static void countDown(Integer x) {
        if ( x < 0) {
            System.out.println("Done");
            return;
        }
        System.out.println(x);
        countDown(x - 1);
    }

    public static void main(String[] args) {
        NoArgFunction<NoArgFunction<String>> createGreetings = ()-> ()-> "Hello function!";
        NoArgFunction<String> greeting = createGreetings.apply();
        System.out.println(greeting.apply());
        MyMath myMath = new MyMath();
        //First class functions in use
        System.out.println(myMath.fourTimes(-25));
        System.out.println(myMath.multiplier(5).apply(5));
        Function<Integer, Integer> multiplierThree = myMath.multiplier(3);
        System.out.println(multiplierThree.apply(-10));
        //Closure
        NoArgFunction<NoArgFunction<String>> createGreater = () -> {
            String name = "EvgenKras";
            return () -> name + " , how are you?";
        };
        System.out.println(createGreater.apply().apply());
        //Higher order function
        HigherOrderFunction higherOrderFunction = new HigherOrderFunction();
        BiFunction<Float, Float, Float> divide = higherOrderFunction.divide;
        System.out.println(divide.apply(3.2f, 5.0f));
        System.out.println(divide.apply(3.2f, 0f));
        BiFunction<Float, Float, Float> divideSafe = higherOrderFunction.divideSafe;
        System.out.println(divideSafe.apply(3f, 4f));
        System.out.println(divideSafe.apply(3f, 0f));
        //Pass function as an argument of a method
        System.out.println(myMath.add(4, 5));
        System.out.println(myMath.subtract(4, 78));
        System.out.println(myMath.combine(myMath::add, 5, 6));
        System.out.println(myMath.combine(myMath::subtract, 5, 6));
//        System.out.println(myMath.combine((x, y) -> x * y));

// partial application
        TriFunction<Integer, Integer, Integer, Integer> sumThreeInts
                = (x, y, z) -> x + y + z;
        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial
                = (x) -> (y, z) -> sumThreeInts.apply(x, y, z);
        Integer sumOfThree = addPartial.apply(5).apply(6, 7);
        BiFunction<Integer, Integer, Function<Integer, Integer>> addTwoPartial
                = (x, y) -> (z) -> sumThreeInts.apply(x, y, z);
        Integer otherSumOfThree = addTwoPartial.apply(5, 6).apply(7);

// Recursion
        countDown(13);
        Function<Integer, Integer> triple = myMath::triple;
        IntFunction<Integer> tripleNew = myMath::triple;
        Integer apply = triple.apply(5);
        Integer applyInt = tripleNew.apply(5);
        System.out.println(apply);
        System.out.println(applyInt);
        Function<Integer, Integer> integerFunction = (Integer someInt) -> someInt * 2 + 1;
        Function<Integer, Integer> integerVFunction = integerFunction.andThen(triple);
        Integer intAndThen = integerVFunction.apply(5);
        System.out.println(intAndThen);
    }
}
