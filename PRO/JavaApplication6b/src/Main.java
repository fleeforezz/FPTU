
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ElectronicProduct ep = new ElectronicProduct("LT01", "LG gram 2in1", "LG", 350000, "2 years", "220V", "1000W");
        System.out.println(ep.getName());
        System.out.println(ep);
        
        CeramicProduct cp = new CeramicProduct("CR01", "Binh su Thai Cong", "France", 1000000, "Binh Su");
        System.out.println(cp.getPrice());
        System.out.println(cp);
        
        FoodProduct fp = new FoodProduct("MT01", "Hao hao chu cay", "Acebook", 360000, new Date(System.currentTimeMillis()), new Date(125, 11, 15));
        System.out.println(fp.getDate());
        System.out.println(fp.getExpireDate());
        System.out.println(fp);
    }
    
}
