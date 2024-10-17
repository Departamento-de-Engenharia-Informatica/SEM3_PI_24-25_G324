package prodPlanSimulator.models;

import java.util.LinkedList;

public class ItemModel {
    private static int idnext = 1;
    private int id;
    private String articleId;
    private String prioraty;
    private LinkedList<String> operation;

    /**
     * Constructor for ItemModel
     *
     * @param id
     * @param prioraty
     * @param operation
     */
    public ItemModel(String articleId, String prioraty, LinkedList<String> operation) {
        this.id = idnext++;
        this.articleId = articleId;
        this.prioraty = prioraty;
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
     * Getter for prioraty
     *
     * @return prioraty of item
     */
    public String getPrioraty() {
        return prioraty;
    }

    /**
     * Getter for operation
     *
     * @return operations of item
     */
    public LinkedList<String> getOperation() {
        return operation;
    }

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
                ", prioraty='" + prioraty + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}