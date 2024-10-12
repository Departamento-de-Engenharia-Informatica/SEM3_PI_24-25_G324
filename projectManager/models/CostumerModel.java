package projectManager.models;

public class CostumerModel extends UserModel{
    private int vatNumber;
    private int phoneNumber;

    public CostumerModel(String email, String name, boolean status, int vatNumber, int phoneNumber) {
        super(email, name, status);
        this.vatNumber = vatNumber;
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }
}
