/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ADMIN
 */
public class Brand {
    private String brandID;
    private String brandName;
    private String location;
    public Brand(){
        
    }

    public Brand(String brandID, String brandName, String location) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.location = location;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    // toString
    @Override
    public String toString() {
        return String.format(
                "=========================\n"
                + "Brand Details:\n"
                + "=========================\n"
                + "ID       : %s\n"
                + "Name     : %s\n"
                + "Location : %s\n"
                + "=========================",
                brandID, brandName, location
        );
    }
    
    
}
