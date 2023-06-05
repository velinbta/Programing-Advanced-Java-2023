package CustomListIterator_09_1;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        // Сортира в нарастващ ред
        for (int index = 0; index < list.size() - 1; index++) {

            T e1 = list.get(index);
            T e2 = list.get(index + 1);

            if (e1.compareTo(e2) > 0) {
                list.swap(index, index + 1);
                index = -1;
            }

        }

    }

}
