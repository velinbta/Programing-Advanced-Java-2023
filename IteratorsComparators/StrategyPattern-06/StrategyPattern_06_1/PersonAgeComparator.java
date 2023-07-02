package StrategyPattern_06_1;

import java.util.Comparator;

// Comparator по възраст
public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        return Integer.compare(first.getAge(), second.getAge());
    }

}
