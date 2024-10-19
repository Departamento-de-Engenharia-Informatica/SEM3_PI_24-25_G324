package prodPlanSimulator.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemModel {
    private static int idnext = 1;
    private int id;
    private String articleId;
    private String priority;
    private HashMap<OperationModel,Boolean> operation;
    private static List<ItemModel> allItems = new ArrayList<>();

    /**
     * Constructor for ItemModel
     *
     * @param id
     * @param priority
     * @param operation
     */
    public ItemModel(String articleId, String priority, HashMap<OperationModel,Boolean> operation) {
        this.id = idnext++;
        this.articleId = articleId;
        this.priority = priority;
        this.operation = operation;
        allItems.add(this);
    }

    /**
     * Getter for id
     *
     * @return id of item
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for articleId
     *
     * @return article Id of item
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * Getter for prioraty
     *
     * @return prioraty of item
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Getter for operation
     *
     * @return operations of item
     */
    public HashMap<OperationModel,Boolean> getOperation() {
        return operation;
    }

    /**
     * Return a List of Items
     *
     * @return allItems
     */
    public static List<ItemModel> getAllItems() {
        return allItems;
    }

    /**
     * Reset the id to 1 and allItems list.
     */
    public static void resetId() {
        allItems.clear();
        idnext = 1;
    }
    /**
     * toString method for ItemModel
     *
     * @return String of ItemModel
     */
    @Override
    public String toString() {
        return "ItemModel{" +
                "ID='" + id + '\'' +
                ", articleId='" + articleId + '\'' +
                ", prioraty='" + priority + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }

    public OperationModel getNextOperation() {
        for (HashMap.Entry<OperationModel, Boolean> entry : operation.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }

    public boolean isCompleted(){
        for(Boolean completed: operation.values()){
            if(!completed){
                return false;
            }
        }
        return true;
    }

    public void CompleteOperation(ItemModel item,OperationModel operation){
        if (allItems.contains(item)) {
            ItemModel complex = allItems.get(allItems.indexOf(item));

            HashMap<OperationModel, Boolean> operations = complex.getOperation();
            if (operations.containsKey(operation)) {
                // Step 4: Mark the operation as completed (true)
                operations.put(operation, true);
            } else {
                // Handle the case when the operation doesn't exist for this item
                System.out.println("Operation not found for the item.");
            }
        } else {
            // Handle the case when the item is not found in the list
            System.out.println("Item not found in the list.");
        }
    }
}