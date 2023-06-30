package Froggy_04_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Iterable class Lake
public class Lake implements Iterable<Integer> {

    private List<Integer> jumps;

    public Lake() {
        this.jumps = new ArrayList<>();
    }

    public void addJump(int jump) {
        jumps.add(jump);
    }

    public int getJump(int index) {
        return this.jumps.get(index);
    }

    public int size() {
        return this.jumps.size();
    }

    public boolean isEmpty() {
        return this.jumps.isEmpty();
    }

    private class Frog implements Iterator<Integer> { // <- Iterator

        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < size();
        }

        @Override
        public Integer next() {
            return jumps.get(this.index++);
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

}
