package prodPlanSimulator.utils;
import prodPlanSimulator.models.*;

import java.util.HashMap;
import java.util.List;

public class ItemParser implements DataParser<ItemModel> {
    /**
     * Parse the data and return an object
     *
     * @param data the data to be parsed
     * @return the object parsed or null if the data is invalid
     */
    @Override
    public ItemModel parse(String[] data) {
        if (data.length <= 0) {
            return null;
        }
        HashMap<OperationModel,Boolean> operations = new HashMap<>();
        List<OperationModel> list= OperationModel.GetAllOperations();
        String article = data[0].trim();
        String priority = data[1].trim();

        // The Operations are from index 2 to the end of the array
        for (int i = 2; i < data.length; i++) {
            if (!data[i].trim().isEmpty()) {
                if(list.contains(data[i].trim())) {
                    operations.put(list.get(list.indexOf(data[i].trim())),false);
                }
            }
        }

        ItemModel item = null;
        if (!article.isEmpty() && !priority.isEmpty()) {
            return new ItemModel(article, priority,operations);
        }
        return null;
    }
}
