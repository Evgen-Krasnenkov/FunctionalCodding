package FunctionalInterface;

import java.util.function.Function;

public class AbsValue {
    public static void main(String[] args) {
       Function<Integer,Integer> absFunction = (x) -> {
            if (x < 0) {
                return -x;
            }
            return x;
        };
        System.out.println(absFunction.apply(-34));
    }
}
