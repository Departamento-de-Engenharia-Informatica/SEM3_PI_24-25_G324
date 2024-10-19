package prodPlanSimulator.controllers;

import prodPlanSimulator.models.MachineModel;
import prodPlanSimulator.models.OperationModel;
import prodPlanSimulator.utils.DataManager;

import java.util.*;

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

    /**
     *
     * @param machineMap
     * @param operation
     * @return List of Machines
     */

    public static List<MachineModel> getAvailableMachinesForOperation(HashMap<MachineModel, Boolean> machineMap, OperationModel operation) {
        List<MachineModel> availableMachines = new ArrayList<>();

        synchronized (machineMap) { // Ensure thread-safe access to machineMap
            for (Map.Entry<MachineModel, Boolean> entry : machineMap.entrySet()) {
                MachineModel machine = entry.getKey();
                Boolean isOccupied = entry.getValue();

                if (!isOccupied && machine.getNameOperation().equals(operation)) {
                    availableMachines.add(machine);
                }
            }
        }

        return availableMachines;
    }
}