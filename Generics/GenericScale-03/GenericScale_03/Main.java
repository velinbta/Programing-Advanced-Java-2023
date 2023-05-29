package GenericScale_03;

public class Main {
    public static void main(String[] args) {

        Scale<String> stringScale = new Scale<>("a", "c");
        String heavierString = stringScale.getHeavier();
        System.out.printf("Heavier string is %s.\n", heavierString);

        Scale<Integer> integerScale = new Scale<>(2, 1);
        int heavierInteger = integerScale.getHeavier();
        System.out.printf("Heavier integer is %d.\n", heavierInteger);

        Scale<Double> doubleScale = new Scale<>(3.14, 5.55);
        double heavierDouble = doubleScale.getHeavier();
        System.out.printf("Heavier double is %.2f.\n", heavierDouble);

        Scale<Long> longScale = new Scale<>((long) Integer.MAX_VALUE, Long.MAX_VALUE);
        long heavierLong = longScale.getHeavier();
        System.out.printf("Heavier long is %d.\n", heavierLong);

    }

}
