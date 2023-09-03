package PetClinics_08_1;

import java.util.*;

public class Main {

    public static final String CREATE_COMMAND = "Create";
    public static final String PET_CREATE_COMMAND = "Pet";
    public static final String CLINIC_CREATE_COMMAND = "Clinic";
    public static final String ADD_COMMAND = "Add";
    public static final String RELEASE_COMMAND = "Release";
    public static final String HAS_EMPTY_ROOMS_COMMAND = "HasEmptyRooms";
    public static final String PRINT_COMMAND = "Print";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        List<Clinic> clinics = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        for (int i = 0; i < lines; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            switch (command) {

                case CREATE_COMMAND: {

                    String type = input[1];
                    String name = input[2];

                    switch (type) {

                        case PET_CREATE_COMMAND:

                            int age = Integer.parseInt(input[3]);
                            String kind = input[4];

                            // Добавя ново животно във временния списък
                            Arrays.stream(input).map(e -> new Pet(name, age, kind)).findFirst()
                                    .ifPresent(pets::add);

                            break;

                        case CLINIC_CREATE_COMMAND:

                            int rooms = Integer.parseInt(input[3]);

                            // Хваща изключение за клиника с четен брой стай
                            try {
                                addNewClinic(clinics, name, rooms);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid Operation!");
                            }

                            break;

                        default:

                            throw illegalException("Unknown type " + type);

                    }

                }
                break;

                case ADD_COMMAND: {

                    String petName = input[1];
                    String clinicName = input[2];

                    // Намира клиниката и животното
                    Pet pet = pets.stream().filter(p -> p.getName().equals(petName)).findFirst().orElse(null);
                    Clinic clinic = clinics.stream().filter(c -> c.getName().equals(clinicName)).
                            findFirst().orElse(null);

                    if (Objects.nonNull(pet) && Objects.nonNull(clinic)) {

                        // Ако е добавено успешно, премахва от временния списък
                        boolean isAdded = clinic.addPet(pet);
                        System.out.println(isAdded);

                        if (isAdded) {
                            pets.remove(pet);
                        }

                    }

                }
                break;

                case RELEASE_COMMAND: {

                    String clinicName = input[1];

                    // В поредност - Пр: от 5 -> 3 4 5 1 2
                    clinics.stream().filter(c -> c.getName().equals(clinicName)).findFirst()
                            .ifPresent(clinic -> System.out.println(clinic.release()));

                }

                break;

                case HAS_EMPTY_ROOMS_COMMAND: {

                    String clinicName = input[1];

                    clinics.stream().filter(c -> c.getName().equals(clinicName)).findFirst()
                            .ifPresent(clinic -> System.out.println(clinic.hasEmptyRooms()));

                }
                break;

                case PRINT_COMMAND: {

                    String clinicName = input[1];

                    Clinic clinic = clinics.stream().filter(c -> c.getName().equals(clinicName))
                            .findFirst().orElse(null);

                    boolean isASingleRoomContent = input.length == 3;

                    if (Objects.nonNull(clinic) && isASingleRoomContent) { // <- Инфо на една стая

                        int room = Integer.parseInt(input[2]);

                        clinic.printSingleRoomContent(room);

                    } else if (Objects.nonNull(clinic)) { // <- Итерира всички стай

                        clinic.forEach(System.out::println);

                    }

                }

                break;

                default:

                    throw illegalException("Unknown command " + command);

            }

        }

    }

    private static void addNewClinic(List<Clinic> clinics, String name, int rooms) {
        // Добавя нова клиника
        Clinic clinic = new Clinic(name, rooms);
        clinics.add(clinic);
    }

    private static IllegalArgumentException illegalException(String message) {
        // Хвърля изключение
        return new IllegalArgumentException(message);
    }

}
