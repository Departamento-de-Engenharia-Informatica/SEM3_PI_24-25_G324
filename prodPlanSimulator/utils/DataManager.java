package prodPlanSimulator.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DataManager<T> {
    private List<T> dataList;

    public DataManager() {
        this.dataList = new LinkedList<>();
    }

    public void addItem(T Item) {
        if (!dataList.contains(Item)) {
            dataList.add(Item);
        }else {
            System.out.println("Item already exists");
        }
    }

    public void removeItem(T Item) {
        if (dataList.contains(Item)) {
            dataList.remove(Item);
        }else {
            System.out.println("Item does not exist");
        }
    }

    public void updateItem(T oldItem, T newItem) {
        int index = dataList.indexOf(oldItem);
        if (index != -1) {
            dataList.set(index, newItem);
        }else {
            System.out.println("Item does not found to update");
        }
    }

    public List<T> getAllItems() {
        return dataList;
    }

    public T getItemByIndex(int index) {
        if (index >= 0 && index < dataList.size()) {
            return dataList.get(index);
        }else {
            System.out.println("Index out of bounds");
            return null;
        }
    }

    public int getSize() {
        return dataList.size();
    }

    public <T> void LoadFile(DataManager<T> manager, DataParser<T> parser, String type, Scanner scanner) {
        System.out.println("Enter the path of the " + type + " file (ex: C:/path/to/" + type + ".csv):");
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.exists() && file.isFile()) {
            try (Scanner fileScanner = new Scanner(file)) {
                fileScanner.nextLine();
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] data = line.split(",");
                    T item = parser.parse(data);
                    if (item != null) {
                        manager.addItem(item);
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
