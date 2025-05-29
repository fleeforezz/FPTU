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

    public String CUS_VALID_ID = "^[CGK]\\d{4}$"; // Start with C,G,K and 4 number after
    
    public String NAME_VALID = "^.{2,25}$"; // A String from 2 to 25 character
    
    public String PHONE_VALID = "^(03[2-9]|05[689]|07[0-9]|08[1-9]|09[0-9])\\d{7}$"; // 03: Viettel, 05: VietNameMobile, 07: MobiFone, 08: Vinaphone, 09: Mobi, Vina, Viettel...
    
    public String EMAIL_VALID = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"; // A valid mail format example@test.com
    
    public String SETMEU_CODE_VALID = "^{\\d{5}$"; // A valid Set Menu Code is 5 characters long
    
    public String ORDER_CODE_DATETIME_FORMAT = "yyyyMMddhhmmss"; // A valid order code with date and time format
    
    public String DATETIME_FORMAT = "dd/MM/yyyy"; // A valid date format

    public static boolean isValid(String data, String pattern) {
        return data.matches(pattern);
    }
}
