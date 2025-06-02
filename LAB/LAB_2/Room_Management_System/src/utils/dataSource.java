/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author jso
 */
public class dataSource {

    /*
     * ###################
     * Active room list
     * ###################
     */
    // Katana Laptop
//    private static final String FEAST_ORDER_FILE_PATH = "D:\\Code-Stuff\\Github_Landing\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\feast_order_service.dat";
    // Shadow Window Desktop
    private static final String ACTIVE_ROOM_LIST_FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\feast_order_service.dat";
    // Shadow linux Desktop
//    private static final String FEAST_ORDER_FILE_PATH = "/home/jso/Documents/GitHub/FPTU/LAB/LAB_1/Traditional_Feast_Management/src/main/java/data/Customers.dat";

    /*
     * #########
     * Customers
     * #########
     */
    // Katana Laptop
//    private static final String CUSTOMERS_FILE_PATH = "D:\\Code-Stuff\\Github_Landing\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\Customers.dat";
    // Shadow Window Desktop
    private static final String CUSTOMERS_FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\Customers.dat";
    // Shadow linux Desktop
//    private static final String CUSTOMERS_FILE_PATH = "/home/jso/Documents/GitHub/FPTU/LAB/LAB_1/Traditional_Feast_Management/src/main/java/data/Customers.dat";

    /*
     * ########
     * Set Menu
     * ########
     */
    // Katana Laptop
//    private static final String SET_MENU_FILE_PATH = "D:\\Code-Stuff\\Github_Landing\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\FeastMenu.csv";
    // Shadow Window Desktop
    private static final String SET_MENU_FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\FeastMenu.csv";
    // Shadow linux Desktop
//    private static final String SET_MENU_FILE_PATH = "/home/jso/Documents/GitHub/FPTU/LAB/LAB_1/Traditional_Feast_Management/src/main/java/data/Customers.dat";

    private dataSource() {
    }

    public static String getACTIVE_ROOM_LIST_FILE_PATH() {
        return ACTIVE_ROOM_LIST_FILE_PATH;
    }

    public static String getCUSTOMERS_FILE_PATH() {
        return CUSTOMERS_FILE_PATH;
    }

    public static String getSET_MENU_FILE_PATH() {
        return SET_MENU_FILE_PATH;
    }
}
