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
//    private static final String ACTIVE_ROOM_LIST_FILE_PATH = "D:\\Code-Stuff\\Github_Landing\\FPTU\\LAB\\LAB_2\\Room_Management_System\\src\\data\\Active_Room_List.txt";
    // Shadow Window Desktop
    private static final String ACTIVE_ROOM_LIST_FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_2\\Room_Management_System\\src\\data\\Active_Room_List.txt";

    /*
     * ################
     * Reservation List
     * ################
     */
    // Katana Laptop
//    private static final String RESERVATION_FILE_PATH = "D:\\Code-Stuff\\Github_Landing\\FPTU\\LAB\\LAB_2\\Room_Management_System\\src\\data\\Reservation_List.txt";
    // Shadow Window Desktop
    private static final String RESERVATION_FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_2\\Room_Management_System\\src\\data\\Reservation_List.txt";
    
    private dataSource() {
    }

    public static String getACTIVE_ROOM_LIST_FILE_PATH() {
        return ACTIVE_ROOM_LIST_FILE_PATH;
    }

    public static String getRESERVATION_FILE_PATH() {
        return RESERVATION_FILE_PATH;
    }
}
