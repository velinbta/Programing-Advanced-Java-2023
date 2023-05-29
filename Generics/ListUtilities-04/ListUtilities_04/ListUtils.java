package ListUtilities_04;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) { // <- Само сравними T
        // Връща най-малкото T
        return list.stream().min(Comparator.naturalOrder())
                .orElseThrow(getIllegalArgumentExceptionEmptyList());
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        // Връща най-голямото T
        return list.stream().max(Comparator.naturalOrder())
                .orElseThrow(getIllegalArgumentExceptionEmptyList());
    }

    private static Supplier<IllegalArgumentException> getIllegalArgumentExceptionEmptyList() {
        return () -> new IllegalArgumentException("List is empty!");
    }

}
