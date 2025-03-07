
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class Tester {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        
        intList.add(5);
        intList.add(2);
        intList.add(1);
        intList.add(5);
        intList.add(4);
        intList.add(3);
        intList.add(7);
        intList.add(99);
        
        System.out.println(intList);
        
        intList.remove(3);
        System.out.println(intList);
        intList.remove(new Integer(3));
        System.out.println(intList);
    }
}
