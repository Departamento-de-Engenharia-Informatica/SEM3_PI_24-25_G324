package prodPlanSimulator.utils;

import prodPlanSimulator.models.MachineModel;
import prodPlanSimulator.models.OperationModel;

import java.util.ArrayList;
import java.util.List;

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
        OperationModel nameOperations = null;
        List<OperationModel> operationModels = new ArrayList<>();
        if (data.length <= 0) {
            return null;
        }
            String idWorkstation = data[0].trim();
            String nameOper = data[1].trim();
            if(!nameOper.isEmpty()) {
                if(!operationModels.contains(nameOper)) {
                    nameOperations = new OperationModel(nameOper);
                }else{
                    nameOperations=operationModels.get(operationModels.indexOf(nameOper));
                }
            }

            int time = Integer.parseInt(data[2].trim());

            if (!idWorkstation.isEmpty() && time > 0) {
                for (MachineModel machine : MachineManager.getAllItems("machines")) {
                    if (machine.getWorkstation().equals(idWorkstation)) {
                        System.out.println("Error: idWorkstation already exists on the list.");
                        return null;
                    }
                }
                return new MachineModel(idWorkstation, nameOperations, time);
            }
            return null;
    }
}
