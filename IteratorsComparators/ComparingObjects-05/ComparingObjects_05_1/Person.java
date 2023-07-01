package ComparingObjects_05_1;

// Comparable class Person
public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person other) {
        // Име, възраст и град да съвпадат
        boolean areEqual = this.getName().compareTo(other.getName()) == 0 &&
                Integer.compare(this.getAge(), other.getAge()) == 0 &&
                this.getTown().compareTo(other.getTown()) == 0;

        if (areEqual)
            return 0;

        return -1;
    }

}
