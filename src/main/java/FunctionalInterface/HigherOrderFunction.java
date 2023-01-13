package FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunction {
     BiFunction<Float, Float, Float> divide = (x, y) -> {
        if (y != 0f) {
            return  x / y;
        }
        System.out.println("Error: can't divide by zero");
        return 0f;
    };
    BiFunction<Float, Float, Float> divideFunction = (x, y) -> x / y;

    Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> checkSecondArgument =
            (function) -> (x, y) -> {
        if (y == 0f) {
            System.out.println("Error: second argument is Zero");
            return 0f;
        }
        return function.apply(x,y);
            };

    BiFunction<Float, Float, Float> divideSafe =  checkSecondArgument.apply(divideFunction);
}
