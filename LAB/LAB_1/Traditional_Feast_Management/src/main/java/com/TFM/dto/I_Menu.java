/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TFM.dto;

/**
 *
 * @author jso
 */
public interface I_Menu {

    void addItem(String s); // Add a menu -> add text to menu

    int getChoice(); // Get user choices

    void showMenu(); // Show menu for user choice

    boolean confirmYesNo(String welcome); // Confirm yes/no
}
