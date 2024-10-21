package prodPlanSimulator.utils;
import prodPlanSimulator.models.*;
import java.util.LinkedList;

public class ItemParser implements DataParser<ItemModel> {
    /**
     * Parse the data and return an object
     *
     * @param data the data to be parsed
     * @return the object parsed or null if the data is invalid
     */
    @Override
    public ItemModel parse(String[] data) {
        if (data.length > 0) {
            String article = data[0].trim();
            String priority = data[1].trim();
            LinkedList nameOperations = new LinkedList();
            // The Operations are from index 2 to the end of the array
            for (int i = 2; i < data.length; i++) {
                if (!data[i].trim().isEmpty()) {
                    nameOperations.add(data[i].trim());
                }
            }

            ItemModel item = null;
            if (!article.isEmpty() && !priority.isEmpty() && !nameOperations.isEmpty()) {
                return new ItemModel(article, priority, nameOperations);
            }
        }
        return null;
    }
}
