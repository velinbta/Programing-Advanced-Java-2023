package GenericBox_01_1;

import java.util.ArrayList;
import java.util.List;

// Generic Box<>
public class Box<T> {

    private List<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public void add(T element) {
        this.box.add(element);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        this.box.forEach(e -> sb.append(String.format("%s: %s", e.getClass().getName(), e))
                .append(System.lineSeparator())); // Името на класа и добавения елемент
        sb.delete(sb.lastIndexOf(System.lineSeparator()), sb.length());

        return sb.toString();

    }

}
