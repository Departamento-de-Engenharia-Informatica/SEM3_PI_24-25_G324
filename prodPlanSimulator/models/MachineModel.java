package prodPlanSimulator.models;

public class MachineModel {
    private String workstation;
    private String nameOperation;
    private int time;

    /**
     * Constructor for MachineModel
     *
     * @param workstation
     * @param nameOperation
     * @param time
     */
    public MachineModel(String workstation, String nameOperation, int time) {
        this.workstation = workstation;
        this.nameOperation = nameOperation;
        this.time = time;
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
    public String getNameOperation() {
        return nameOperation;
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
     * toString method for MachineModel
     *
     * @return String of MachineModel
     */
    @Override
    public String toString() {
        return "MachineModel{" +
                "Workstation='" + workstation + '\'' +
                ", name of operation='" + nameOperation + '\'' +
                ", time=" + time +
                '}';
    }
}
