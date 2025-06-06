/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;

/**
 *
 * @author jso
 */
public interface acceptable {
    
    public String DATETIME_FORMAT = "dd/MM/yyyy";
    
    public static boolean isValid(String data, String pattern) {
        return data.matches(pattern);
    }
    
}
