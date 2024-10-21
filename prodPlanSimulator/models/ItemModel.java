package prodPlanSimulator.models;

import java.util.LinkedList;

public class ItemModel {
    private static int idnext = 1;
    private int id;
    private String articleId;
    private String priority;
    private LinkedList<String> operation;

    /**
     * Constructor for ItemModel
     *
     * @param id
     * @param priority
     * @param operation
     */
    public ItemModel(String articleId, String priority, LinkedList<String> operation) {
        this.id = idnext++;
        this.articleId = articleId;
        this.priority = priority;
        this.operation = operation;
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
     * Getter for priority
     *
     * @return priority of item
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Getter for operation
     *
     * @return operations of item
     */
    public LinkedList<String> getOperation() {
        return operation;
    }

    /**
     * Reset the id to 1
     */
    public static void resetId() {
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
                ", priority='" + priority + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}