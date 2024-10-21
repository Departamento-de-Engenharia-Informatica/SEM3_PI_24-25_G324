package prodPlanSimulator.controllers;

import prodPlanSimulator.models.MachineModel;
import prodPlanSimulator.utils.DataManager;

import java.util.Scanner;

public class MachineController {

    /**
     * print all machines
     *
     * @param manager
     */
       public void PrintMachines(DataManager<MachineModel> manager) {
        System.out.println("Machines:");
        for (MachineModel machine : manager.getAllItems("machines")) {
            System.out.println(machine);
        }
    }
}