package projectManager.models;
public class UserModel {
    private String name;
    private boolean status;
    private String email;

    public UserModel(String email, String name, boolean status) {
        this.email = email;
        this.name = name;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
