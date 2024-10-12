package prodPlanSimulator.models;

public class MachineModel {
    private String name;
    private String model;
    private int year;

    public MachineModel(String name, String model, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid machine name.");
        }
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Invalid machine model.");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Invalid machine year.");
        }
        this.name = name;
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MachineModel{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
