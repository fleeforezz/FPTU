/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/*
 class này không dùng để đúc ra object mà nó dùng để lưu các method xử lí việc 
nhập liệu

 */
public class Inputter {

    // tạo cái Scanner để thuộc tính 
    public static Scanner sc = new Scanner(System.in);

    // những method hỗ trợ cho việc nhập liệu 
    // method nhập số nguyên  chuẩn 
    public static int getAnInteger(String inpMsg, String errMsg) {
        // câu mời nhập 
        System.out.println(inpMsg);
        // nhập đến khio nào dừng thì thôi 
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                // nếu không có lỗi thì trả ra number 
                return number;
            } catch (Exception e) {
                // nếu có lỗi thì thông báo lỗi 
                System.out.println(errMsg);
            }
        }
    }

    // nhập số nguyên chuẩn nhưng phải trong khoảng yêu cầu 
    public static int getAnInteger(String inpMsg, String errMsg,
            int lowerBound, int upperBound) {
        // đầu tiên tránh nhập láo khoảng 
        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        // hiên thị câu nhập 
        System.out.println(inpMsg);
        // kiểm tra nhập đúng không 
        while (true) {
            try {
                // check xem con số có nằm trong khaongr không 
                int number = Integer.parseInt(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    
                        throw new Exception();
                }
                    return number;
            }catch (Exception e) {
                    // nếu có lỗi thì thông báo lỗi 
                     System.out.println(errMsg);
            }

            }
        }
    // nhập số thực chuẩn 
    public static double getAnDouble(String inpMsg , String errMsg){
         // câu mời nhập 
        System.out.println(inpMsg);
        // nhập đến khio nào dừng thì thôi 
        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine());
                // nếu không có lỗi thì trả ra number 
                return number;
            } catch (Exception e) {
                // nếu có lỗi thì thông báo lỗi 
                System.out.println(errMsg);
            }
        }
    }
     // nhập số thực chuẩn nhưng phải trong khoảng yêu cầu 
    public static double getAnDouble(String inpMsg, String errMsg,
                                  double lowerBound,  double upperBound) {
        // đầu tiên tránh nhập láo khoảng 
        if (lowerBound > upperBound) {
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        // hiên thị câu nhập 
        System.out.println(inpMsg);
        // kiểm tra nhập đúng không 
        while (true) {
            try {
                // check xem con số có nằm trong khaongr không 
                double number = Double.parseDouble(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    
                        throw new Exception();
                }
                    return number;
            }catch (Exception e) {
                    // nếu có lỗi thì thông báo lỗi 
                     System.out.println(errMsg);
            }

            }
    }
    // nhập chuỗi không được bỏ trống
    public static String getString(String inpMsg , String errMsg){
        // nhập câu mời 
       
        while(true){
             System.out.println(inpMsg);
            String str = sc.nextLine();
            try {
                if(str.isEmpty()){
                     throw new Exception();
                 }
                 return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    // nhập chuỗi không được bỏ trống theo regex 
     public static String getString(String inpMsg , String errMsg , String regex){
        // nhập câu mời 
       
        while(true){
             System.out.println(inpMsg);
            String str = sc.nextLine();
            try {
                if(str.isEmpty() || !str.matches(regex)){
                     throw new Exception();
                 }
                 return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    
}
