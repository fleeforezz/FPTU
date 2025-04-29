package entity;

public class Account {
    private String id;
    private String name;
    private String password;
    private String accountType;

    public Account() {
    }

    public Account(String id, String name, String password, String accountType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", password=" + password + ", accountType=" + accountType + "]";
    }

}
