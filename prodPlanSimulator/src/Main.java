import prodPlanSimulator.controllers.ItemController;
import prodPlanSimulator.controllers.MachineController;
import prodPlanSimulator.models.ItemModel;
import prodPlanSimulator.models.MachineModel;
import prodPlanSimulator.utils.DataManager;
import prodPlanSimulator.utils.ItemParser;
import prodPlanSimulator.utils.MachineParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start();

    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        MachineController machineController = new MachineController();
        ItemController itemController = new ItemController();

        DataManager<MachineModel> machineManager = new DataManager<>();
        DataManager<ItemModel> itemManager = new DataManager<>();

        MachineParser machineParser = new MachineParser(machineManager);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Load the machines file");
            System.out.println("2. Load the items file");
            System.out.println("3. Print machines");
            System.out.println("4. Print items");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    itemManager.LoadFile(machineManager, machineParser, "machines", scanner);
                    break;
                case 2:
                    itemManager.LoadFile(itemManager, new ItemParser(), "items", scanner);
                    break;
                case 3:
                    machineController.PrintMachines(machineManager);
                    break;
                case 4:
                    itemController.PrintItems(itemManager);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

}