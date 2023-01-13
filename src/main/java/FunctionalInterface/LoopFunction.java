package FunctionalInterface;

import java.util.function.BiConsumer;

public class LoopFunction {
    private void forEachCellMatrix(BiConsumer<Integer, Integer> action, int rowNumbers, int columnNumbers) {
        for (int i = 0; i < rowNumbers; i++) {
            for (int j = 0; j < columnNumbers; j++) {
                action.accept(i,j);
            }
        }
    }
}
