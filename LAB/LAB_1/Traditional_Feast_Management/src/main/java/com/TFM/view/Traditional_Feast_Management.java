/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.TFM.view;

import com.TFM.controller.Menu;
import com.TFM.dto.I_Menu;

/**
 *
 * @author jso
 */
public class Traditional_Feast_Management {

    public static void main(String[] args) {
        
        I_Menu menu = new Menu();
        
        menu.addItem("1. Register customers");
        menu.addItem("1. Update customer information");
        menu.addItem("1. Search for customer information by name");
        menu.addItem("1. Display feast menus");
        menu.addItem("1. Place a feast menu");
        menu.addItem("1. Update order information");
        menu.addItem("1. Save data to file");
        menu.addItem("1. Display customer or Order lists");
        
        int choice;
        boolean cont = true;
        
    }
}
