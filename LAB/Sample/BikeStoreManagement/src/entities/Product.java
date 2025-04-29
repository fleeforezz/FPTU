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
public class Product {

    private String productID;
    private String productName;
    private String brandID;
    private String categoryID;
    private int modelYear;
    private int listPrice;

    public Product() {

    }

    public Product(String productID, String productName, String brandID, String categoryID, int modelYear, int listPrice) {
        this.productID = productID;
        this.productName = productName;
        this.brandID = brandID;
        this.categoryID = categoryID;
        this.modelYear = modelYear;
        this.listPrice = listPrice;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getListPrice() {
        return listPrice;
    }

    public void setListPrice(int listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return String.format(
                "Product Details:\n"
                + "-----------------\n"
                + "ID       : %s\n"
                + "Name     : %s\n"
                + "Brand ID : %s\n"
                + "Category ID: %s\n"
                + "Model year: %d\n"
                + "Price    : %d\n",
                productID, productName, brandID, categoryID, modelYear, listPrice
        );
    }
}
