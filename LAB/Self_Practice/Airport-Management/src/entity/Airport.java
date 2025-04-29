package entity;

public class Airport {
    private String name;
    private String address;
    private String code;

    public Airport() {
    }

    public Airport(String name, String address, String code) {
        this.name = name;
        this.address = address;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Airport [name=" + name + ", address=" + address + ", code=" + code + "]";
    }

}
