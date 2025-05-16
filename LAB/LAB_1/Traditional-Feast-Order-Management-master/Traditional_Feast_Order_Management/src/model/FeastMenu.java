/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hi
 */
public class FeastMenu {
    // các props của thực đơn 
    private String menuCode;
    private String menuName;
    private double price;
    private String ingredients;
    
    
    // constructor của thực đơn 

    public FeastMenu() {
    }

    public FeastMenu(String menuCode, String menuName, double price, String ingredients) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.price = price;
        this.ingredients = ingredients;
    }
    
    // getter và setter của menu 

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    
    // hàm in thông tin của thực đơn 
    
    public String toString (){
        String str5 = String.format("%-12s| %-12s| %-12f| %4s", 
                menuCode , menuName , price , ingredients);
        return str5;
    }
    
    

}
