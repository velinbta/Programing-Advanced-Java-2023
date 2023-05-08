package CatLady_09_1;

public class Cat {
    private String name;

    public Cat(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s", getName());
    }

}
