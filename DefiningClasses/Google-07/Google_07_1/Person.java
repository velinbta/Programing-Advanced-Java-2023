package Google_07_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    // Клас Person с полета от статични вътрешни класове
    private String name;
    private Company company;
    private List<Pokemon> pokemonCollection;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public static class Company {

        private String companyName;
        private String department;
        private Double salary;

        public Company(String companyName, String department, Double salary) {
            this.companyName = companyName;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("\n%s %s %.2f", this.companyName, this.department, this.salary);
        }

    }

    public static class Pokemon {

        private String pokemonName;
        private String pokemonType;

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }

        public String getPokemonName() {
            return this.pokemonName;
        }

        public String getPokemonType() {
            return this.pokemonType;
        }

    }

    public static class Parent {

        private String parentName;
        private String parentBirthday;

        public Parent(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }

        public String getParentName() {
            return this.parentName;
        }

        public String getParentBirthday() {
            return this.parentBirthday;
        }

    }

    public static class Child {

        private String childName;
        private String childBirthday;

        public Child(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }

        public String getChildName() {
            return this.childName;
        }

        public String getChildBirthday() {
            return this.childBirthday;
        }

    }

    public static class Car {

        private String model;
        private Integer speed;

        public Car(String model, Integer speed) {
            this.model = model;
            this.speed = speed;
        }

        public String getModel() {
            return this.model;
        }

        public Integer getSpeed() {
            return this.speed;
        }

        @Override
        public String toString() {
            return String.format("\n%s %d", getModel(), getSpeed());
        }

    }

    private <T> boolean collectionIsNull(List<T> list) { // <- Проверява дали колекцията е null
        return list == null;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getPersonName() {
        return this.name;
    }

    public void setCompany(String companyName, String department, Double salary) {
        this.company = new Company(companyName, department, salary);
    }

    public Company getCompany() {
        return this.company;
    }

    public void addPokemon(String pokemonName, String pokemonType) {
        if (collectionIsNull(this.pokemonCollection)) {
            this.pokemonCollection = new ArrayList<>();
        }
        this.pokemonCollection.add(new Pokemon(pokemonName, pokemonType));
    }

    public String getPokemonCollection() {
        if (collectionIsNull(this.pokemonCollection)) {
            return null;
        } else {
            return this.pokemonCollection.stream().map(pokemon ->
                            String.format("\n%s %s", pokemon.getPokemonName(), pokemon.getPokemonType()))
                    .collect(Collectors.joining(""));
        }
    }

    public void addParent(String parentName, String parentBirthday) {
        if (collectionIsNull(this.parents)) {
            this.parents = new ArrayList<>();
        }
        this.parents.add(new Parent(parentName, parentBirthday));
    }

    public String getParents() {
        if (collectionIsNull(this.parents)) {
            return null;
        } else {
            return this.parents.stream().map(parent ->
                            String.format("\n%s %s", parent.getParentName(), parent.getParentBirthday()))
                    .collect(Collectors.joining(""));
        }
    }

    public void addChild(String childName, String childBirthday) {
        if (collectionIsNull(this.children)) {
            this.children = new ArrayList<>();
        }
        this.children.add(new Child(childName, childBirthday));
    }

    public String getChildren() {
        if (collectionIsNull(this.children)) {
            return null;
        } else {
            return this.children.stream().map(child ->
                            String.format("\n%s %s", child.getChildName(), child.getChildBirthday()))
                    .collect(Collectors.joining(""));
        }
    }

    public void setCar(String model, Integer speed) {
        this.car = new Car(model, speed);
    }

    public Car getCar() {
        return this.car;
    }

    @Override
    public String toString() {
        return String.format("%s\nCompany:%s\nCar:%s\nPokemon:%s\nParents:%s\nChildren:%s",
                        getPersonName(), getCompany(), getCar(), getPokemonCollection(), getParents(), getChildren())
                .replaceAll("null", ""); // <- Замества всички null с ""
    }

}
