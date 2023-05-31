package GenericBox_01_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

        IntStream.range(0, this.box.size()).forEach(e -> {
            sb.append(String.format("%s: %s", this.box.get(e).getClass().getName(), this.box.get(e)));
            if (e != this.box.size() - 1) {
                sb.append(System.lineSeparator());
            }
        }); // Името на класа и всеки добавен елемент

        return sb.toString();
    }

}
