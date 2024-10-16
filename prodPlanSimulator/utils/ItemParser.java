package prodPlanSimulator.utils;

import prodPlanSimulator.models.*;

public class ItemParser implements DataParser<ItemModel> {
    private DataManager<MachineModel> machineManager;

    public ItemParser(DataManager<MachineModel> machineManager) {
        this.machineManager = machineManager;
    }

    @Override
    public ItemModel parse(String[] data) {
        if (data.length == 7) {
            String code = data[0].trim();
            String name = data[1].trim();
            String description = data[2].trim();
            double price = Double.parseDouble(data[3].trim());
            int productionTime = Integer.parseInt(data[4].trim());
            String machineName = data[5].trim();
            int quantity = Integer.parseInt(data[6].trim());

            MachineModel machine = null;
            for (MachineModel m : machineManager.getAllItems()) {
                if (m.getName().equals(machineName)) {
                    machine = m;
                    break;
                }
            }

            if (machine != null) {
                return new ItemModel(code, name, description, price, productionTime, machine, quantity);
            }
        }
        return null;
    }
}
