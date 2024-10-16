package prodPlanSimulator.controllers;

import prodPlanSimulator.models.ItemModel;
import prodPlanSimulator.models.MachineModel;
import prodPlanSimulator.utils.DataManager;

import java.util.Scanner;

public class ItemController {
    Scanner scanner = new Scanner(System.in);
    public void AddItem(DataManager<ItemModel> manager, DataManager<MachineModel> machineManager) {
        System.out.println("Add new item");
        System.out.println("Enter the item code:");
        String code = scanner.nextLine();
        System.out.println("Enter the item name:");
        String name = scanner.nextLine();
        System.out.println("Enter the item description:");
        String description = scanner.nextLine();
        System.out.println("Enter the item price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the item production time:");
        int productionTime = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the item machine name:");
        String machineName = scanner.nextLine();
        System.out.println("Enter the item quantity:");
        int quantity = Integer.parseInt(scanner.nextLine());

        MachineModel machine = null;
        for (MachineModel m : machineManager.getAllItems()) {
            if (m.getName().equals(machineName)) {
                machine = m;
                break;
            }
        }
        if (machine != null) {
            ItemModel newItem = new ItemModel(code, name, description, price, productionTime, machine, quantity);
            manager.addItem(newItem);
            System.out.println("Item added successfully");
        } else {
            System.out.println("Machine not found");
        }
    }

    public void RemoveItem(DataManager<ItemModel> manager) {
        System.out.println("Enter the item code to remove:");
        String code = scanner.nextLine();
        for (ItemModel item : manager.getAllItems()) {
            if (item.getCode().equals(code)) {
                manager.removeItem(item);
                System.out.println("Item removed successfully");
                return;
            }
        }
        System.out.println("Item not found");
    }

    public void PrintItems(DataManager<ItemModel> manager) {
        System.out.println("Items:");
        for (ItemModel item : manager.getAllItems()) {
            System.out.println(item);
        }
    }
}