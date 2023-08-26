package PetClinics_08_1;

import java.util.*;
import java.util.stream.IntStream;

// Iterable class Clinic
public class Clinic implements Iterable<Pet> {

    private String name;
    private final int totalRooms;
    private final int centre; // <- 5 -> 3, 1 -> 1
    private int availableRooms;
    private Map<Integer, Pet> pets;

    private final List<Integer> addOrder; // <- Поредност на добавяне на животни
    private final List<Integer> releaseOrder; // <- Поредност на освобождаване

    public Clinic(String name, int rooms) {
        this.name = name;
        this.totalRooms = rooms;
        validateClinic(); // <- Нечетен брой стай
        this.centre = (rooms / 2) + 1;
        this.availableRooms = rooms;
        this.pets = getInitialEmptyRooms();
        this.addOrder = getAddOrder();
        this.releaseOrder = getReleaseOrder();
    }

    public boolean addPet(Pet pet) {

        // Добавя в мап по поредност на добавяне, ако има свободни стай
        if (!this.hasEmptyRooms()) {
            return false;
        }

        for (int room : this.addOrder) {

            if (isCurrentRoomEmpty(room)) {

                this.pets.put(room, pet);
                this.availableRooms--;
                return true;

            }

        }

        return false;
    }

    public boolean release() {

        // Осбовождава в поредност -> 5 - 3, 4, 5, 1, 2, ако има животно
        if (this.totalRooms == this.availableRooms) { // <- Ако няма какво да освобождава
            return false;
        }

        for (int room : this.releaseOrder) {

            if (!isCurrentRoomEmpty(room)) {

                this.pets.put(room, null);
                this.availableRooms++;

                return true;
            }

        }

        return false;
    }

    public void printSingleRoomContent(int room) {

        // Съдържанието на единична стая
        if (room > this.totalRooms || room < 1)
            System.out.println("Incorrect room number");
        else if (this.isCurrentRoomEmpty(room))
            printEmpty();
        else
            System.out.println(this.pets.get(room));

    }

    public boolean hasEmptyRooms() {
        return this.availableRooms > 0;
    }

    private void validateClinic() {

        // Нечетен брой
        boolean isValid = this.totalRooms > 0 && this.totalRooms % 2 != 0;
        if (!isValid)
            throw new IllegalArgumentException("Rooms must be a positive odd number!");

    }

    public String getName() {
        return this.name;
    }

    @Override
    public Iterator<Pet> iterator() {
        // Анонимна инстанция на итератор
        return new Iterator<>() {

            private int currentRoom = 1;

            @Override
            public boolean hasNext() {

                boolean hasRooms = this.currentRoom <= totalRooms;

                if (hasRooms && isCurrentRoomEmpty(this.currentRoom)) { // <- Ако е празна стаята

                    printEmpty(); // <- Принтира съобщение, че е празна

                    this.currentRoom++;
                    return this.hasNext(); // <- Връща отново същия метод

                }

                return hasRooms;

            }

            @Override
            public Pet next() {

                return pets.get(this.currentRoom++);

            }

        };

    }

    private Map<Integer, Pet> getInitialEmptyRooms() {

        // Номера и Null objects -> за първоначалните стаи
        Map<Integer, Pet> petsMap = new LinkedHashMap<>();
        IntStream.rangeClosed(1, this.totalRooms).forEach(room -> petsMap.put(room, null));

        return petsMap;
    }

    private List<Integer> getAddOrder() {

        // Пр -> 5 - 3, 2, 4, 1, 5
        List<Integer> addList = new ArrayList<>();

        for (int i = 0; i < this.centre; i++) {

            if (i != 0) {
                addList.add(this.centre - i);
                addList.add(this.centre + i);
            } else
                addList.add(this.centre);

        }

        return addList;
    }

    private List<Integer> getReleaseOrder() {

        // Пр -> 5 - 3, 4, 5, 1, 2
        List<Integer> releaseList = new ArrayList<>();

        IntStream.rangeClosed(this.centre, this.totalRooms).forEach(releaseList::add);
        IntStream.range(1, this.centre).forEach(releaseList::add);

        return releaseList;
    }

    private void printEmpty() {
        System.out.println("Room empty");
    }

    private boolean isCurrentRoomEmpty(int room) {
        return this.pets.get(room) == null;
    }

}
