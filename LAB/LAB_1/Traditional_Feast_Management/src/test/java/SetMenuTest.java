
import controller.setMenuController;
import model.setMenu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jso
 */
public class SetMenuTest {
    public static void main(String[] args) {
        setMenuController setMenuController1 = new setMenuController();
        
        setMenuController1.loadRecFromFile();
        
        for (setMenu menu : setMenuController1) {
            System.out.println(menu.getId());
        }
    }
}
