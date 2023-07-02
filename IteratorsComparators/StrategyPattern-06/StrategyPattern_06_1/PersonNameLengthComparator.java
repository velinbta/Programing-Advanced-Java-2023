package StrategyPattern_06_1;

import java.util.Comparator;

// Comparator по дължина на името - при равенство сравнява първата буква от името (case insensitive)
public class PersonNameLengthComparator implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {

        int result = Integer.compare(first.getName().length(), second.getName().length());

        if (result == 0) {
            char firstLetter = Character.toLowerCase(first.getName().charAt(0));
            char secondLetter = Character.toLowerCase(second.getName().charAt(0));
            result = Character.compare(firstLetter, secondLetter);
        }

        return result;
    }

}
