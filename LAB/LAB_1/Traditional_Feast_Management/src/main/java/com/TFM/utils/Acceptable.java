/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TFM.utils;

/**
 *
 * @author jso
 */
public interface Acceptable {

    public String CUS_VALID_ID = "^[CGK]\\d{4}$"; // Start with C,G,K and 4 number after
    
    public String NAME_VALID = "^\\d{2,25}$"; // A String from 2 to 25 character
    
    public String PHONE_VALID = "^03[2-9]|05[689]|07[0-9]|08[1-9]|09[0-9]\\d{7}$"; // 03: Viettel, 05: VietNameMobile, 07: MobiFone, 08: Vinaphone, 09: Mobi, Vina, Viettel...
    
    public String EMAIL_VALID = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2}$"; // A valid mail format example@test.com

    public static boolean idValid(String data, String pattern) {
        return data.matches(pattern);
    }
}
