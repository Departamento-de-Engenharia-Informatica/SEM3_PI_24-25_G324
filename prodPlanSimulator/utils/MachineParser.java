package prodPlanSimulator.utils;

import prodPlanSimulator.models.MachineModel;

public class MachineParser implements DataParser<MachineModel> {
    private DataManager<MachineModel> MachineManager;

    /**
     * Constructor for MachineParser
     *
     * @param MachineManager
     */
    public MachineParser(DataManager<MachineModel> MachineManager) {
        this.MachineManager = MachineManager;
    }

    /**
     * Parse the data and return an object
     *
     * @param data the data to be parsed
     * @return the object parsed or null if the data is invalid
     */
    @Override
    public MachineModel parse(String[] data) {
        if (data.length > 0) {
            String idWorkstation = data[0].trim();
            String nameOper = data[1].trim();
            int time = Integer.parseInt(data[2].trim());

            if (!idWorkstation.isEmpty() && !nameOper.isEmpty() && time > 0) {
                for (MachineModel machine : MachineManager.getAllItems("machines")) {
                    if (machine.getWorkstation().equals(idWorkstation)) {
                        System.out.println("Error: idWorkstation already exists on the list.");
                        return null;
                    }
                }
                return new MachineModel(idWorkstation, nameOper, time);
            }
        }
        return null;
    }
}
