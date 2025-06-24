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

    public String NATIONAL_ID_VALID = "^\\d{12,}$"; // valid national id

    public String FULLNAME_VALID = "^[A-Za-z][A-Za-z\\s]{1,24}$"; // Valid fullname

    public String DATETIME_FORMAT = "dd/MM/yyyy"; // Valid date time 

    public String MONTH_REVENUE_FORMAT = "MM/yyyy"; // Valid revenue report input
    
    public String GENDER_VALID = "^(Male|Female)$"; // Valid gender
    
    public String PHONE_VALID = "^(03[2-9]|05[689]|07[0-9]|08[1-9]|09[0-9])\\d{7}$"; // 03: Viettel, 05: VietNameMobile, 07: MobiFone, 08: Vinaphone, 09: Mobi, Vina, Viettel...
    
    public String DESIRED_ROOM_ID_VALID = "^[A-Za-z]\\d{0,4}$";
    
    public String ROOM_TYPE = "^[A-Za-z]+$";
    
    public String AUTO_GENERATE_CODE_TIME_FORMAT = "yyyyMMddhhmmss";

    public static boolean isValid(String data, String pattern) {
        return data.matches(pattern);
    }

}
