
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class VendorList extends ArrayList<Vendor>{
    public void addVendor(Vendor v) {
        this.add(v);
    }
    
    public double getVendorSaleById(int id) {
        for (Vendor v : this) {
            if (v.getId() == id) {
                return v.getSale();
            }
        }
        return Double.parseDouble(String.format("%.3f", id));
    }
    
    public Vendor getVendorWithMaxSale() {
        double maxSale = Double.MIN_VALUE;
        for (Vendor v : this) {
            if (v.getSale() > maxSale) {
                maxSale = v.getSale();
            }
        }
        // Find vendor
        for (Vendor v : this) {
            if (v.getSale() == maxSale) {
                return v;
            }
        }
        return null;
    }
    
    public double getTotalSaleAllVendors() {
        double total = 0;
        for (Vendor v : this) {
            total += v.getSale();
        }
        return total;
    }
    
    public void printVendorList() {
        ArrayList<Vendor> temp = (ArrayList<Vendor>) this.clone();
        Collections.sort(temp); // Sort
        for (Vendor vendor : temp) {
            System.out.println(vendor);
        }
    }
}
