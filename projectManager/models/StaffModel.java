package projectManager.models;

public class StaffModel extends UserModel {
    private String password;
    private String type;

    public StaffModel(String email, String name, String password, boolean status, String type) {
        super(email, name, status);
        this.password = password;
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
