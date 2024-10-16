package prodPlanSimulator.models;

public class ItemModel {
    private String code;
    private String name;
    private String description;
    private double price;
    private int productionTime;
    private MachineModel machine;
    private int quantity;

    /**
     * Constructor for ItemModel
     *
     * @param code
     * @param name
     * @param description
     * @param price
     * @param productionTime
     * @param machine
     * @param quantity
     */
    public ItemModel(String code, String name, String description, double price, int productionTime, MachineModel machine, int quantity) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.productionTime = productionTime;
        this.machine = machine;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public MachineModel getMachine() {
        return machine;
    }

    public int getQuantity() {
        return quantity;
    }


    @Override
    public String toString() {
        return "ItemModel{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", productionTime=" + productionTime +
                ", machine=" + machine +
                ", quantity=" + quantity +
                '}';
    }
}