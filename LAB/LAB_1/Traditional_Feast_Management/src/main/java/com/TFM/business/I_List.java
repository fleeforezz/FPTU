/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TFM.business;

import java.util.List;

/**
 *
 * @author jso
 */
public interface I_List<T> {
    
    boolean addRec(); // Add new element

    boolean updateRec(T code); // Update by code 

    boolean removeRec(T code); // Remove by code
    
    List<T> loadRecFromFile(); // Load record from file
    
    void sortRec(); // Sort element in the List
    
    List<T> searchRecByName(T name); // Search element by name
    
    T searchRecById(String id); // Search element by ID
    
    void displayRec(); // Show detail of each element in the List
    
    boolean saveToFile(); // Save element information into file
}
