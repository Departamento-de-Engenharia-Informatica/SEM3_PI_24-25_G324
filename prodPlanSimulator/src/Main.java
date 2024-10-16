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

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Load the machines file");
            System.out.println("2. Load the items file");
            System.out.println("3. Add a machine");
            System.out.println("4. Remove a machine");
            System.out.println("5. Add an item");
            System.out.println("6. Remove an item");
            System.out.println("7. Print machines");
            System.out.println("8. Print items");
            System.out.println("9. Exit");
            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    itemManager.LoadFile(machineManager, new MachineParser(), "machines", scanner);
                    break;
                case 2:
                    itemManager.LoadFile(itemManager, new ItemParser(machineManager), "items", scanner);
                    break;
                case 3:
                    machineController.AddMachine(machineManager);
                    break;
                case 4:
                    machineController.RemoveMachine(machineManager);
                    break;
                case 5:
                    itemController.AddItem(itemManager, machineManager);
                    break;
                case 6:
                    itemController.RemoveItem(itemManager);
                    break;
                case 7:
                    machineController.PrintMachines(machineManager);
                    break;
                case 8:
                    itemController.PrintItems(itemManager);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

}