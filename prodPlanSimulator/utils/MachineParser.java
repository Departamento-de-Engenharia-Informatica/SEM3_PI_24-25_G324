package prodPlanSimulator.utils;

import prodPlanSimulator.models.MachineModel;

public class MachineParser implements DataParser<MachineModel> {
    @Override
    public MachineModel parse(String[] data) {
        if (data.length == 3) {
            String name = data[0].trim();
            String model = data[1].trim();
            int year = Integer.parseInt(data[2].trim());

            if (!name.isEmpty() && !model.isEmpty() && year > 0) {
                return new MachineModel(name, model, year);
            }
        }
        return null;
    }
}
