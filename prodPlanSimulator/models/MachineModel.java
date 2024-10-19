package prodPlanSimulator.models;

import java.util.ArrayList;
import java.util.List;

public class MachineModel {
    private String workstation;
    private OperationModel nameOperationModel;
    private int time;
    private static List<MachineModel> allMachines = new ArrayList<>();

    /**
     * Constructor for MachineModel
     *
     * @param workstation
     * @param nameOperationModel
     * @param time
     */
    public MachineModel(String workstation, OperationModel nameOperationModel, int time) {
        this.workstation = workstation;
        this.nameOperationModel = nameOperationModel;
        this.time = time;
        allMachines.add(this);
    }

    /**
     * Getter for workstation
     *
     * @return ID of workstation
     */
    public String getWorkstation() {
        return workstation;
    }

    /**
     * Getter for nameOperation
     *
     * @return name Operation of workstation
     */
    public OperationModel getNameOperation() {
        return nameOperationModel;
    }

    /**
     * Getter for time
     *
     * @return time of workstation
     */
    public int getTime() {
        return time;
    }

    /**
     * Get a list of All Machines
     *
     * @return allMachines
     */
    public static List<MachineModel> getAllMachines() {
        return allMachines;
    }

    /**
     * Reset all machines
     */
    public static void reset() {
        allMachines.clear();
    }

    /**
     * toString method for MachineModel
     *
     * @return String of MachineModel
     */
    @Override
    public String toString() {
        return "MachineModel{" +
                "Workstation='" + workstation + '\'' +
                ", name of operation='" + nameOperationModel + '\'' +
                ", time=" + time +
                '}';
    }
}
