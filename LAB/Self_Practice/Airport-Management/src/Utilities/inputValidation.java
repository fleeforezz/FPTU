package Utilities;

import java.util.Scanner;

public class inputValidation {


    /*
    *########## 
    * Valid ID
    *##########
    */
    public static boolean isValidId(String id) {

        String pattern = "";

        if (id != null && id.matches(pattern)) {
            return true;
        }

        return false;
    }

    /*
    *########## 
    * Integer
    *##########
    */
    
}
