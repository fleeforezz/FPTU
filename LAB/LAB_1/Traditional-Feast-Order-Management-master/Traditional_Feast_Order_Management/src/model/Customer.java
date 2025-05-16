
package model;


public class Customer {
    // các props của customer
    private String cus_id;
    private String name;
    private String phoneNumber;
    private String email;
    
    // cái phễu của customer 

    public Customer() {
    }

    public Customer(String cus_id, String name, String phoneNumber, String email) {
        this.cus_id = cus_id.toUpperCase();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    // setter và getter của Customer 

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int findPos(String name){
        for (int i = name.length() - 1 ; i >= 0; i--) {
            if(name.charAt(i) == ' '){
                return i;
            }
        }
        return -1;
    }
    
    // hàm in thông tin của khách hàng 
    public String toString (){
        // tìm vị trí của fname 
        int keyPos = findPos(name);
        String fname = name.substring(keyPos, name.length());
        String lname = name.substring(0, keyPos);
        
        String str = String.format(" %-12s| %-2s, %8s| %-12s| %4s", 
                cus_id , fname ,lname , phoneNumber , email);
        return str;
    }
    
    public String objectIsSaved(){
        String str1 = String.format("%-12s|%-12s| %-12s| %4s", 
                cus_id , name, phoneNumber , email);
        return str1;
    }
    
   
}
