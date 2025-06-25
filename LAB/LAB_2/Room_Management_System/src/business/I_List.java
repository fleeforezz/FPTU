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
 */
public interface I_List<T> {
    
    T addRec();
    
    T updateRec(String code);
    
    boolean removeRec(String code);
    
    List<T> loadRecFromFile();
    
    List<T> sortRec(ArrayList<T> recList);
    
    void searchRecByName(ArrayList<T> recList);
    
    T searchRecById(String code);
    
    void displayrec(ArrayList<T> recList);
    
    void saveToFile();
}
