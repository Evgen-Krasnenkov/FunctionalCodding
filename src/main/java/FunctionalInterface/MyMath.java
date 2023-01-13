package FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MyMath {
    public MyMath() {
    }

    protected Integer triple(Integer x) {
        return x * 3;
    }
    protected Integer add(int x, int y){
        return x + y;
    }
    protected Integer subtract(int x, int y){
        return x - y;
    }
    protected Integer combine(BiFunction<Integer, Integer, Integer> myBiFunc, int x, int y){
        return  myBiFunc.apply(x, y);
    }

    public Integer fourTimes(int x){
        return  x * 4;
    }
    // First class function
    public Function<Integer, Integer> multiplier(Integer x) {
        return (Integer y) -> y * x;
    }

}
