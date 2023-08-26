package PetClinics_08_1;

// Pojo class Pet
public class Pet {

    private final String name;
    private final int age;
    private final String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.getName(), this.age, this.kind);
    }

}
