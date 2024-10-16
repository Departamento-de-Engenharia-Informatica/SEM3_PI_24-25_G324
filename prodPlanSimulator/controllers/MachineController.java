package prodPlanSimulator.controllers;

import prodPlanSimulator.models.MachineModel;
import prodPlanSimulator.utils.DataManager;

import java.util.Scanner;

public class MachineController {
   Scanner scanner = new Scanner(System.in);
    public void AddMachine(DataManager<prodPlanSimulator.models.MachineModel> manager) {
        System.out.println("Add new machine");
        System.out.println("Enter the machine name:");
        String name = scanner.nextLine();
        System.out.println("Enter the machine model:");
        String model = scanner.nextLine();
        System.out.println("Enter the machine year:");
        int year = Integer.parseInt(scanner.nextLine());

        prodPlanSimulator.models.MachineModel newmachine = new prodPlanSimulator.models.MachineModel(name, model, year);
        manager.addItem(newmachine);
        System.out.println("Machine added successfully");
    }

    public void RemoveMachine(DataManager<prodPlanSimulator.models.MachineModel> manager) {
        System.out.println("Enter the machine name to remove:");
        String name = scanner.nextLine();
        for (prodPlanSimulator.models.MachineModel machine : manager.getAllItems()) {
            if (machine.getName().equals(name)) {
                manager.removeItem(machine);
                System.out.println("Machine removed successfully");
                return;
            }
        }
        System.out.println("Machine not found");
    }

    public void PrintMachines(DataManager<MachineModel> manager) {
        System.out.println("Machines:");
        for (MachineModel machine : manager.getAllItems()) {
            System.out.println(machine);
        }
    }
}