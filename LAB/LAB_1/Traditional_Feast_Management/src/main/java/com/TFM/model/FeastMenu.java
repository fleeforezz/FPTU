/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TFM.model;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 *
 * @author jso
 */
public class FeastMenu {

    private String id;
    private String name;
    private double price;
    private String ingredients;

    public FeastMenu() {
    }

    public FeastMenu(String id, String name, double price, String ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
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

    /*
        #####################
        Display Feast Menu Info
        #####################
     */
    public String display() {
        StringTokenizer st = new StringTokenizer(ingredients, "#");
        DecimalFormat formatter = new DecimalFormat("#, ###, ### Vnd");
        
        String appetizer = st.nextToken().trim();
        String mainCourse = st.nextToken().trim();
        String desert = st.nextToken().trim();
        String priceFormat = formatter.format(price);
                
        return String.format("""
                             Code         :  %s
                             Name         :  %s
                             Price        :  %s
                             Ingredients  : 
                               %s
                               %s
                               %s
                             -----------------------------------------------------------------------------
                             """,
                id, name, priceFormat, appetizer, mainCourse, desert
        );
    }
}
