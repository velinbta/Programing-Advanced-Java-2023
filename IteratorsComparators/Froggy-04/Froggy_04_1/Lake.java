package Froggy_04_1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Iterable class Lake
public class Lake implements Iterable<Integer> {

    private List<Integer> values;

    public Lake(Integer... values) {
        this.values = Arrays.asList(values);
    }

    private class Frog implements Iterator<Integer> { // <- Стандартен итератор

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < values.size();
        }

        @Override
        public Integer next() {
            return values.get(index++);
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    public String getEvenIndicesFirstOddSecond() {

        StringBuilder output = new StringBuilder();

        for (int index = 0; index < this.values.size(); index += 2) {

            output.append(this.values.get(index));
            if (index + 2 < this.values.size())
                output.append(", ");
        }

        if (!this.values.isEmpty() && this.values.size() > 1)
            output.append(", ");

        for (int index = 1; index < this.values.size(); index += 2) {

            output.append(this.values.get(index));

            if (index + 2 < this.values.size())
                output.append(", ");

        }

        return output.toString();
    }

}
