import prodPlanSimulator.controllers.ItemController;
import prodPlanSimulator.controllers.MachineController;
import prodPlanSimulator.models.ItemModel;
import prodPlanSimulator.models.MachineModel;
import prodPlanSimulator.utils.CSVParser;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CSVParser parser = new CSVParser();
        ItemController itemController = new ItemController();
        MachineController machineController = new MachineController();

        System.out.println("Enter the path to the items file:");
        String filePath = scanner.nextLine();

        try {
            Object result = parser.parseCSV(filePath);

            if (result instanceof List) {
                List<?> dataList = (List<?>) result;

                if (!dataList.isEmpty() && dataList.get(0) instanceof ItemModel) {
                    System.out.println("Items loaded successfully.");
                    List<ItemModel> items = (List<ItemModel>) dataList;
                    itemController.getItems().addAll(items);
                    itemController.printItems();
                } else if (!dataList.isEmpty() && dataList.get(0) instanceof MachineModel) {
                    System.out.println("Machines loaded successfully.");
                    List<MachineModel> machines = (List<MachineModel>) dataList;
                    machineController.getMachines().addAll(machines);
                    machineController.printMachines();
                } else {
                    System.out.println("Unknown data type in CSV.");
                }
            } else {
                System.out.println("No data found in CSV.");
            }
        } catch (Exception e) {
            System.err.println("Error importing data: " + e.getMessage());
        }
    }
}