/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TFM.controller;

import com.TFM.utils.Utils;
import com.TFM.business.I_Menu;
import java.util.ArrayList;

/**
 *
 * @author jso
 */
public class Menu extends ArrayList<String> implements I_Menu {

    public Menu() {
        super();
    }

    /*
        ########
        Add Item
        ########
     */
    @Override
    public void addItem(String s) {
        this.add(s);
    }

    /*
        ####################
        Get Choice from user
        ####################
     */
    @Override
    public int getChoice() {
        return Utils.getInt("Input your choice", 1, this.size());
    }

    /*
        #########
        Show Menu
        #########
     */
    @Override
    public void showMenu() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }

    /*
        ################
        Confirm yes / no
        ################
     */
    @Override
    public boolean confirmYesNo(String welcome) {
        boolean result = false;
        
        result = Utils.confirmYesNo(welcome);
        
        return result;
    }

}
