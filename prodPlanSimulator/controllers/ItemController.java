package prodPlanSimulator.controllers;

import prodPlanSimulator.models.ItemModel;
import prodPlanSimulator.models.MachineModel;
import prodPlanSimulator.utils.DataManager;

import java.util.Scanner;

public class ItemController {

    /**
     * Print all items
     *
     * @param manager
     */
    public void PrintItems(DataManager<ItemModel> manager) {
        System.out.println("Items:");
        for (ItemModel item : manager.getAllItems("items")) {
            System.out.println(item);
        }
    }
}