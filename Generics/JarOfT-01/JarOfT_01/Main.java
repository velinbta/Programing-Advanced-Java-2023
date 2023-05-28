package JarOfT_01;

public class Main {
    public static void main(String[] args) {

        Jar<Character> characterJar = new Jar<>();

        characterJar.add('!');
        characterJar.add('e');
        characterJar.add('g');
        characterJar.add('a');
        characterJar.add('u');
        characterJar.add('g');
        characterJar.add('n');
        characterJar.add('a');
        characterJar.add('l');

        characterJar.add(' ');
        characterJar.add('t');
        characterJar.add('s');
        characterJar.add('e');
        characterJar.add('b');

        characterJar.add(' ');
        characterJar.add('e');
        characterJar.add('h');
        characterJar.add('t');

        characterJar.add(' ');
        characterJar.add(',');
        characterJar.add('a');
        characterJar.add('v');
        characterJar.add('a');
        characterJar.add('J');

        while (!characterJar.isEmpty()){
            System.out.print(characterJar.remove());
        }

    }

}
