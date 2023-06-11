package ListyIterator_01_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListyIterator {

    private final List<String> collection;
    private int internalIndex = 0;

    public ListyIterator(String... elements) {
        this.collection = new ArrayList<>(Arrays.asList(elements));
    }

    public boolean move() {
        // Премества индекса, ако има следващ елемент
        if (this.hasNext()) {
            this.internalIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.internalIndex < this.collection.size() - 1;
    }

    public void printCurrentIndex() {
        // Принтира елемента на текущия индекс, ако не е празна колекцията
        if (this.collection.isEmpty()) {
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(this.collection.get(this.internalIndex));
    }

    @Override
    public String toString() {
        return this.collection.stream().collect(Collectors.joining(System.lineSeparator()));
    }

}
