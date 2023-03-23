package SetsMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        // Съхранявам в азбучен ред - магазините, в тях са продукти и цени в ред на добавяне
        Map<String, Map<String, Double>> storeProductPriceMap = new TreeMap<>();

        while (!input.equals("Revision")) {

            String[] infoArr = input.split(",\\s+");
            String store = infoArr[0];
            String product = infoArr[1];
            double price = Double.parseDouble(infoArr[2]);

            // Добавям, ако липсва магазина
            storeProductPriceMap.putIfAbsent(store, new LinkedHashMap<>());
            storeProductPriceMap.get(store).putIfAbsent(product, price); // <- Добавям продукта и неговата цена

            input = scanner.nextLine();

        }

        storeProductPriceMap.entrySet().forEach(shop -> {

            System.out.printf("%s->\n", shop.getKey());

            shop.getValue().entrySet().forEach(product ->
                    System.out.printf("Product: %s, Price: %.1f\n", product.getKey(), product.getValue()));

        });

    }

}
