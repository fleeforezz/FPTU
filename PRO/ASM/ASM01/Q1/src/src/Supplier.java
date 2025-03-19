/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class Supplier {
    private int id;
    private String name;
    private String address;
    private String phone;
    private boolean status;

    public Supplier() {
    }

    public Supplier(int id, String name, String address, String phone) {
        this.id = id;
        setName(name);
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return toTitleCase(name);
    }

    public void setName(String name) {
        if (name != null && (name.length() >= 5 && name.length() <= 50)) {
            status = true;
            this.name = name;
        } else {
            status = false;
            this.name = "No name";
        }
    }

    public String getAddress() {
        return toTitleCase(address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String pattern = "^0\\d{9,10}$";
        if (phone.matches(pattern)) {
            this.phone = phone;
        } else {
            this.phone = "000.000.000";
        }
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String toTitleCase(String s) {
        String[] words = s.split(" ");
        String result = "";
        
        for (String word : words) {
            if (word.trim().length() > 0) {
                String temp = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                result += (temp + " ");
            }
        }
        
        return result.trim();
    }

    @Override
    public String toString() {
        if (status == true) {
            return "Available";
        }
        
        return "Unavailable";
    }
    
    
    
}
