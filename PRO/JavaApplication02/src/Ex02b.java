/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class Ex02b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        System.out.println(a/b);
        System.out.println(a%b);
        System.out.println((double)a/b);
        
        int x = 5;
        System.out.println(x++); // Phải cộng trc r tăng
        System.out.println(++x); // Phải tăng biến lên r cộng
        System.out.println(--x);
        System.out.println(x--);
        
        int y = 5;
        int z = 4;
        System.out.println(y++ - ++z);
        
        int u = 10;
        int s = 10;
        System.out.println(++u + s++);
        
        int t = 15;
        System.out.println(t>>1);
        System.out.println(t);
    }
    
}
