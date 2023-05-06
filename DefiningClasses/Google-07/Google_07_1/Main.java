package Google_07_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> peopleList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] personData = input.split("\\s+");
            String personName = personData[0];
            String detail = personData[1];

            Person person = peopleList.stream().filter(p -> p.getPersonName().equals(personName))
                    .findFirst().orElse(null); // <- Ако човека не съществува, го създавам и добавям в списъка

            if (person == null) {
                person = new Person(personName);
                peopleList.add(person);
            }

            // Търся по вътрешните класове и записвам информацията за всеки един човек
            switch (detail) {

                case "company": // <- Презаписва се при новодостигнала информация

                    String companyName = personData[2];
                    String department = personData[3];
                    Double salary = Double.parseDouble(personData[4]);

                    person.setCompany(companyName, department, salary);

                    break;

                case "pokemon":

                    String pokemonName = personData[2];
                    String pokemonType = personData[3];

                    person.addPokemon(pokemonName, pokemonType);

                    break;

                case "parents":

                    String parentName = personData[2];
                    String parentBirthday = personData[3];

                    person.addParent(parentName, parentBirthday);

                    break;

                case "children":

                    String childName = personData[2];
                    String childBirthday = personData[3];

                    person.addChild(childName, childBirthday);

                    break;

                case "car": // <- Презаписва се при новодостигнала информация

                    String model = personData[2];
                    Integer speed = Integer.parseInt(personData[3]);

                    person.setCar(model, speed);

                    break;

                default:
                    throw new IllegalArgumentException("Invalid data information: " + detail);

            }

            input = scanner.nextLine();
        }

        String nameSearch = scanner.nextLine();

        // Намирам човека в списъка и принтирам информацията за него
        Person person = peopleList.stream().filter(p -> p.getPersonName().equals(nameSearch))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Person does not exist: " + nameSearch));

        System.out.println(person);

    }

}
