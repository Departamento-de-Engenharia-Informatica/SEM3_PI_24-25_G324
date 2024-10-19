package prodPlanSimulator.models;

import java.util.ArrayList;
import java.util.List;

public class OperationModel {
    private static int idnext = 1;
    private int id;
    public String name;
    private static List<OperationModel> allOperationModels = new ArrayList<>();

    /**
     * Constructor for MachineModel
     *
     * @param name
     */
    public OperationModel(String name) {
        this.id = idnext++;
        this.name = name;
        allOperationModels.add(this);
    }

    /**
     * Get name of a Operation
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of operation
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get a list of All Operations
     *
     * @return operations
     */
    public static List<OperationModel> GetAllOperations() {
        return allOperationModels;
    }

    /**
     * Reset all operations and the ID counter
     */
    public static void reset() {
        allOperationModels.clear();
        idnext = 1;
    }
}
