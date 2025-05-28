/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jso
 * @param <T>
 */
public interface I_List<T> {
    
    boolean addRec(); // Add new element

    boolean updateRec(String code); // Update by code 

    boolean removeRec(T code); // Remove by code
    
    List<T> loadRecFromFile(); // Load record from file
    
    List<T> sortRec(ArrayList<T> recList); // Sort element in the List
    
    void searchRecByName(ArrayList<T> recList); // Search element by name
    
    T searchRecById(String id); // Search element by ID
    
    void displayRec(ArrayList<T> recList); // Show detail of each element in the List
}
