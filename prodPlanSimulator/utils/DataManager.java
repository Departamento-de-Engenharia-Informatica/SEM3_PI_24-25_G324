package prodPlanSimulator.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import prodPlanSimulator.models.ItemModel;

public class DataManager<T> {
    private Map<String, List<T>> dataMap;

    /**
     * Constructor for DataManager
     */
    public DataManager() {
        this.dataMap = new HashMap<>();
    }

    /**
     * Add item to the specific list in the dataMap
     *
     * @param type the type of the list (e.g., "items", "machines")
     * @param item the item to be added
     */
    public void addItem(String type, T Item) {
        dataMap.putIfAbsent(type, new LinkedList<>());
        List<T> dataList = dataMap.get(type);

        if (!dataList.contains(Item)) {
            dataList.add(Item);
        } else {
            System.out.println("Item already exists");
        }
    }

    /**
     * Get all items for a specific type
     *
     * @param type the type of the data list
     * @return the dataList of items for the given type
     */
    public List<T> getAllItems(String type) {
        return dataMap.getOrDefault(type, new LinkedList<>());
    }

    /**
     * Get item by index for a specific type
     *
     * @param type  the type of the data list
     * @param index the index of the item
     * @return the item at the specified index or null if out of bounds
     */
    public T getItemByIndex(String type, int index) {
        List<T> datalist = dataMap.get(type);
        if (datalist != null && index >= 0 && index < datalist.size()) {
            return datalist.get(index);
        } else {
            System.out.println("Index out of bounds");
            return null;
        }
    }

    /**
     * Load the CSV file for a specific type
     *
     * @param manager the manager to add the item
     * @param parser  parser to parse the data
     * @param type    type of the file (e.g., "machines", "items")
     * @param scanner scanner to read the input
     */
    public <T> void LoadFile(DataManager<T> manager, DataParser<T> parser, String type, Scanner scanner) {
        System.out.println("Enter the path of the " + type + " file (ex: C:/path/to/" + type + ".csv):");
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.exists() && file.isFile()) {
            // if exists a list of that type, clear it before add new items
            if (manager.dataMap.containsKey(type)) {
                manager.dataMap.put(type, new LinkedList<>());
                System.out.println(type + " list cleared");

                if (type.equalsIgnoreCase("items")) {
                    ItemModel.resetId();
                    System.out.println("ItemModel ID reset");
                }
            }

            try (Scanner fileScanner = new Scanner(file)) {
                fileScanner.nextLine();
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] data = line.split(";");
                    T item = parser.parse(data);
                    if (item != null) {
                        manager.addItem(type, item);
                    } else {
                        System.out.println("Invalid data in line: " + line);
                    }
                }
                System.out.println(type + " loaded successfully");
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else {
            System.out.println("Invalid file path or file does not exist");
        }
    }
}