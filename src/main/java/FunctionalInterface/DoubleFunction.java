package FunctionalInterface;

import java.util.function.BiFunction;

public class DoubleFunction {
    public static void main(String[] args) {
        BiFunction<Integer, String, Integer> multiplyStringLength = (x, y) -> x * y.length();
        System.out.println(multiplyStringLength.apply(3, "Max"));
        TriFunction<Integer, String, Integer, Integer> multiplyStringLengthPlus = (x, y, z) -> x * y.length() + z;
        System.out.println(multiplyStringLengthPlus.apply(2, "max", 5));
        NoArgFunction<String> hiString = () -> "Hello";
        System.out.println(hiString.apply());
    }
}
