package FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class Main {

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
