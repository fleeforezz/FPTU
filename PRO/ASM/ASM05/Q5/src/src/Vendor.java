
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jso
 */
public class Vendor implements Comparable<Vendor>{

    private int id;
    private String name;
    private String address;
    private String phone;
    private double sale;

    public Vendor() {
        setId(0);
        setName("");
        setAddress("");
        setSale(0);
    }

    public Vendor(int id, String name, String address, String phone, double sale) {
        this.id = id;
        setName(name);
        setAddress(address);
        setPhone(phone);
        setSale(sale);
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
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("No Name");
        }
    }

    public String getAddress() {
        return toTitleCase(address);
    }

    public void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address;
        } else {
            System.out.println("No address");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String pattern_1 = "^0\\d{8,9}$";
        String pattern_2 = "^\\(0\\d{2}\\)\\d{8}$";
        if (phone.matches(pattern_1) || phone.matches(pattern_2)) {
            this.phone = phone;
        } else {
            System.out.println("No phone");
        }
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        if (sale >= 100 && sale <= 5000000) {
            this.sale = sale;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vendor other = (Vendor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.sale) != Double.doubleToLongBits(other.sale)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
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
        return getId() + ", " + getName() + ", " + getAddress() + ", " + getPhone() + ", " + String.format("%.3f", getSale());
    }

    @Override
    public int compareTo(Vendor that) {
        if (this.getSale() < that.getSale()) {
            return 1;
        } else if (this.getSale() > that.getSale()) {
            return -1;
        } else {
            return this.getName().compareTo(that.getName());
        }
    }
    

}
