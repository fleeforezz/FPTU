package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import model.Customer;
import tools.Acceptable;
import tools.Inputter;

public class Customers {

    // anh quản lí các khách hàng 
    public ArrayList<Customer> cusList = new ArrayList<>();

    private boolean isSaved;

    public boolean isIsSaved() {
        return isSaved;
    }

    // hàm tìm khách hàng trong mảng 
    public Customer searchCustomerById(String cusId) {
        Customer cus;
        for (Customer customer : cusList) {
            if (customer.getCus_id().equals(cusId)) {
                return customer;
            }
        }
        return null;
    }

    // hàm thêm một khách hàng 
    public void addNewCustomer() {
        // nhập các thông tin của khách hàng 
        // nhập id cho khách hàng 

        // cấm trùng id 
        String cusId = "";
        // kiểm tra cấm trùng id
        boolean isCheck;
        do {
            isCheck = false;
            cusId = Inputter.getString("Input your id (C|G|K|????|?is number): ",
                    "Data is invalid! Re-enter...");
            Customer cus = searchCustomerById(cusId);
            if (Acceptable.isValid(cusId, Acceptable.CUS_ID_VALID) && cus == null) {
                isCheck = true;
            } else {
                System.out.println("Data is invalid! Re-enter... ");
            }

        } while (!isCheck);

        // nhập name
        String name = Inputter.getString("Input Your Name",
                "Data is invalid! Re-enter...", Acceptable.NAME_VALID);

        // nhập số điện thoại 
        String phoneNumber = Inputter.getString("Input Your phoneNumber: ",
                "Data is invalid! Re-enter...", Acceptable.PHONE_VALID);
        // nhập email 
        String email = Inputter.getString("Input Your Email",
                "Data is invalid! Re-enter...", Acceptable.EMAIL_VALID);

        Customer newCus = new Customer(cusId, name, phoneNumber, email);
        if (newCus != null) {
            cusList.add(newCus);
            System.out.println("Adding successfully!!!");
        }
    }

    // hàm cập nhập khách hàng 
    public void updateCustomer() {
        // nhập id khách hàng cần tìm 
        String keyId = "";

        keyId = Inputter.getString("Input your is customer you wanna to update",
                "Data is invalid! Re-enter... ");

        Customer updateCus = searchCustomerById(keyId);
        if (Acceptable.isValid(keyId, Acceptable.CUS_ID_VALID) && updateCus == null) {
            System.out.println("This customer does not exist!!!");
        } else {
            // nhập name
            String newName = Inputter.getString("Input Your Name",
                    "Data is invalid! Re-enter...", Acceptable.NAME_VALID);

            // nhập số điện thoại 
            String newPhoneNumber = Inputter.getString("Input Your phoneNumber",
                    "Data is invalid! Re-enter...", Acceptable.PHONE_VALID);

            // nhập email 
            String newEmail = Inputter.getString("Input Your Email",
                    "Data is invalid! Re-enter...", Acceptable.EMAIL_VALID);

            updateCus.setPhoneNumber(newPhoneNumber);
            updateCus.setName(newName);
            updateCus.setEmail(newEmail);

            cusList.set(cusList.indexOf(updateCus), updateCus);
            System.out.println("Updating successfully!!!");
        }
    }
    // hàm tìm thông tin theo name

    public void seachByName(ArrayList<Customer> searchedList) {

        // nhập name khách hàng cần tìm 
        String keyName = Inputter.getString("Input name a part of name: ",
                "Data is invalid! Re-enter...");
        // duyệt mảng và tìm 
        for (Customer cus : cusList) {
            if (cus.getName().contains(keyName)) {
                searchedList.add(cus);
            } else {
                System.out.println("No one matches the search criteria");
            }
        }
        this.displayCustomerList(searchedList);

    }

    // hàm show customer 
    public void displayCustomerList(ArrayList<Customer> cusList) {
        // in ra các sinh viên đã tìm thấy 
        String str = String.format(
                "  |------------------------------------------------------------------|\n"
                + "  | Code  |Customer Name        |  Phone      | Email   \n"
                + "  |------------------------------------------------------------------|\n");
        String str1 = String.format(
                "  |------------------------------------------------------------------|");

        if (cusList.isEmpty()) {
            System.out.println("No data in system");
        } else {
            System.out.println(str);
            for (Customer customer : cusList) {
                System.out.println(customer.toString());
            }
            System.out.println(str1);
        }
    }

    // hàm ghi file 
    public void saveToFile() {
        // tạo object file 
        File f = new File("D:\\Lab211\\lab2\\Customer.csv");
        try {
            // tạo ra anh ghi file 
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            // duyệt mảng 
            for (Customer cus : cusList) {

                writer.write(cus.objectIsSaved());
                writer.write("\n");
            }
            this.isSaved = true;
            writer.flush(); // lưu rồi tắt

        } catch (Exception e) {
            System.out.println("File lỗi rồi nè: " + e);
        }
    }

    public Customer dataToObject(String line) {

        StringTokenizer st = new StringTokenizer(line, "|");

        // xử lí lần lượt các propos 
        String cus_id = st.nextToken().trim();
        String name = st.nextToken().trim();
        String phoneNumber = st.nextToken().trim();
        String email = st.nextToken().trim();

        // đức ra object và trả ra object
        Customer cus = new Customer(cus_id, name, phoneNumber, email);
        return cus;
    }

    // hàm đọc file 
    public void readFromFile() {
        File f = new File("D:\\Lab211\\lab2\\Customer.csv");
        if (!f.exists()) {
            System.out.println("file not exist!!!");
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while (line != null) {
                Customer cus = dataToObject(line);

                if (cus != null) {
                    cusList.add(cus);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File lỗi rồi " + e);
        }
    }

}
