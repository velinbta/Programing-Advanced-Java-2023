package SetsMaps;

import java.util.*;

public class LegendaryFarming_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryItemsQuantityMap = fillInMapWithLegendaryItems();
        Map<String, Integer> keyMaterialsQuantityMap = fillInMapWithKeyMaterials();
        Map<String, Integer> junkMaterialsQuantityMap = new TreeMap<>();

        while (!isItemFarmed(legendaryItemsQuantityMap)) { // <- Ако някой от трите е достигнал >= 250

            String[] materialsArr = scanner.nextLine().split("\\s+");

            for (int i = 1; i < materialsArr.length; i += 2) {
                // Изваждам материал и количество от масива
                String material = materialsArr[i].toLowerCase();
                int quantity = Integer.parseInt(materialsArr[i - 1]);

                // Попълвам данните във всичките Map
                fillInMaterialsInAllMaps(legendaryItemsQuantityMap, keyMaterialsQuantityMap,
                        junkMaterialsQuantityMap, material, quantity);

                // Ако след добавянето условието се е изпълнило, не добавям още материали
                if (isItemFarmed(legendaryItemsQuantityMap)) {
                    break;
                }

            }

        }
        // Проверявам, кой item е достигнал >=250 и съответно вадя разликата
        // от 250 на важните материали на този item
        if (legendaryItemsQuantityMap.get("Shadowmourne") >= 250) {
            keyMaterialsQuantityMap.put("shards", keyMaterialsQuantityMap.get("shards") - 250);
            System.out.println("Shadowmourne obtained!");

        } else if (legendaryItemsQuantityMap.get("Valanyr") >= 250) {
            keyMaterialsQuantityMap.put("fragments", keyMaterialsQuantityMap.get("fragments") - 250);
            System.out.println("Valanyr obtained!");

        } else if (legendaryItemsQuantityMap.get("Dragonwrath") >= 250) {
            keyMaterialsQuantityMap.put("motes", keyMaterialsQuantityMap.get("motes") - 250);
            System.out.println("Dragonwrath obtained!");

        }

        keyMaterialsQuantityMap.entrySet().stream()
                .sorted((left, right) -> { // <- Сортирам стойностите, първо в низходящ ред
                    int result = right.getValue() - left.getValue();
                    if (result == 0) // <- Ако са равни, по азбучен ред
                        return left.getKey().compareTo(right.getKey());
                    else
                        return result;
                }).forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));

        junkMaterialsQuantityMap.entrySet().forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));

    }

    private static Map<String, Integer> fillInMapWithLegendaryItems() {
        // Попълва Map с легендарни items
        Map<String, Integer> legendaryItemsQuantityMap = new HashMap<>();
        legendaryItemsQuantityMap.put("Shadowmourne", 0);
        legendaryItemsQuantityMap.put("Valanyr", 0);
        legendaryItemsQuantityMap.put("Dragonwrath", 0);

        return legendaryItemsQuantityMap;
    }

    private static Map<String, Integer> fillInMapWithKeyMaterials() {
        // Попълва Map с важните материали
        Map<String, Integer> keyMaterialsQuantityMap = new HashMap<>();
        keyMaterialsQuantityMap.put("shards", 0);
        keyMaterialsQuantityMap.put("motes", 0);
        keyMaterialsQuantityMap.put("fragments", 0);

        return keyMaterialsQuantityMap;
    }

    private static boolean isItemFarmed(Map<String, Integer> legendaryItemsQuantityMap) {
        // Проверява дали, някой е достигнал или преминал >=250
        return legendaryItemsQuantityMap.get("Shadowmourne") >= 250
                || legendaryItemsQuantityMap.get("Valanyr") >= 250
                || legendaryItemsQuantityMap.get("Dragonwrath") >= 250;
    }

    private static boolean isMaterialKeyElement(String material) {
        // Проверява дали е важен/основен елемент
        return material.equals("shards") || material.equals("motes") || material.equals("fragments");
    }

    private static void fillInMaterialsInAllMaps(Map<String, Integer> legendaryItem, Map<String, Integer> key,
                                                 Map<String, Integer> junk, String material, int quantity) {
        // Попълва материалите във всичките Map и обновява количествата
        if (isMaterialKeyElement(material)) { // <- Ако е важен

            key.put(material, key.get(material) + quantity); // <- Обновява количеството в Map

            switch (material) { // <- Обновява количеството, според материала в легендарния Map
                case "shards":
                    legendaryItem.put("Shadowmourne", legendaryItem.get("Shadowmourne") + quantity);
                    break;
                case "fragments":
                    legendaryItem.put("Valanyr", legendaryItem.get("Valanyr") + quantity);
                    break;
                case "motes":
                    legendaryItem.put("Dragonwrath", legendaryItem.get("Dragonwrath") + quantity);
                    break;
            }

        } else {  // <- Ако е junk item

            junk.putIfAbsent(material, 0);
            junk.put(material, junk.get(material) + quantity); // <- Обновява количеството в Map

        }

    }

}
