/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TFM.dto;

import java.util.List;

/**
 *
 * @author jso
 */
public interface I_List {

    boolean add(); // Add new element

    boolean update(String code); // Update by code 

    Object remove(String code); // Remove by code
    
    void sort(); // Sort element in the List
    
    List<Object> searchByName(String name); // Search element that it's name contain string from the keyboard
    
    void display(); // Show detail of each element in the List

    boolean readFromFile(String filePath); // Load data from file
    
    boolean saveToFile(); // Save element information into file
}
