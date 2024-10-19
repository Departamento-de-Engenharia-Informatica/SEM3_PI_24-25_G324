package prodPlanSimulator.controllers;

import prodPlanSimulator.models.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulatorController {
    private HashMap<MachineModel,Boolean> machineMap=new HashMap<>(); // Boolean, check if is occupied or not (true if it's occupied, false if it's not)
    private List<ItemModel> itemMap=new ArrayList<>();
    private ExecutorService executorService;

    public void Processing(){
        executorService = Executors.newFixedThreadPool(4);
        //Load machines and itemMap
        for(MachineModel m : MachineModel.getAllMachines()) {
            machineMap.put(m, false);
        }
        itemMap=ItemModel.getAllItems();

        for(ItemModel i : itemMap) {
            if(i.isCompleted()) {
                System.out.println("The item "+i.getArticleId()+" is completed");
            }else {
                OperationModel nextOperation = i.getNextOperation();
                List<MachineModel> availablemachines = MachineController.getAvailableMachinesForOperation(machineMap, nextOperation);
                if(!availablemachines.isEmpty()) {
                    for(MachineModel m : availablemachines) {
                        executorService.submit(() -> processItemOnMachine(i, m, nextOperation));
                    }
                }
            }
        }
    }

    private void processItemOnMachine(ItemModel item, MachineModel machine, OperationModel operation) {
        // Mark the machine as occupied
        synchronized (machineMap) { // Ensure thread-safe access to machineMap
            machineMap.put(machine, true);
        }

        // Simulate the processing time
        int operationTime = machine.getTime();
        System.out.println("Processing " + item.getArticleId() + " on " + machine.getWorkstation() + " for operation " + operation.getName() + " (Time: " + operationTime + "ms)");

        try {
            Thread.sleep(operationTime); // Simulate processing time for the operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Mark the operation as complete for the item
        item.CompleteOperation(item,operation);

        // Mark the machine as available again
        synchronized (machineMap) {
            machineMap.put(machine, false);
        }

        System.out.println("Completed operation " + operation.getName() + " for item " + item.getArticleId() + " on " + machine.getWorkstation());
    }

}
