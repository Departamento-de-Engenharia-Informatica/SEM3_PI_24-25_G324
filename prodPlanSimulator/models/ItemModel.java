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
     * @param code
     * @param name
     * @param description
     * @param price
     * @param productionTime
     * @param machine
     * @param quantity
     */
    public ItemModel(String code, String name, String description, double price, int productionTime, MachineModel machine, int quantity) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Invalid item code.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid item name.");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid item description.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Invalid item price.");
        }
        if (productionTime < 0) {
            throw new IllegalArgumentException("Invalid item production time.");
        }
        if (machine == null) {
            throw new IllegalArgumentException("Invalid item machine.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid item quantity.");
        }
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.productionTime = productionTime;
        this.machine = machine;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public MachineModel getMachine() {
        return machine;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public void setMachine(MachineModel machine) {
        this.machine = machine;
    }

    public void setCode(String code) {
        this.code = code;
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
