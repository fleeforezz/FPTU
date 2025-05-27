
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import utils.acceptable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jso
 */
public class DateTimeTest {

    public static void main(String[] args) {
//        LocalDateTime now = LocalDateTime.now();

//        System.out.println("Current date and time: " + now.getDayOfMonth());
//        Date now = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat(acceptable.DATETIME_FORMAT);
//        
//        String sampleCode = sdf.format(now);
//        
//        ArrayList<String> sampleList = new ArrayList();
//        
//        sampleList.add(sampleCode);
//        
//        System.out.println("Code that have in the list: ");
//        for (String string : sampleList) {
//            System.out.println(string);
//        }
        Scanner sc = new Scanner(System.in);

        LocalDate inputDate = null;
        
        LocalDate now = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("Enter event date: ");
            String input = sc.nextLine();
            
            try {
                inputDate = LocalDate.parse(input, formatter);
                
                if (inputDate.isAfter(now)) {
                    System.out.println("Valid future datetime: " + inputDate.format(formatter));
                    break;
                } else {
                    System.out.println("Not a valid future datetime");
                }
                
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format date time. Please try again");
                System.out.println(e.getMessage());
            }
        }
    }
}
