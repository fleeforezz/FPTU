
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import model.FeastMenu;
import model.Order;
import tools.Inputter;


public class FeastMenus {
   public ArrayList<FeastMenu> feaMenu = new ArrayList<>();
   
   
    
     public FeastMenu dataToObject(String line) {

         StringTokenizer st = new StringTokenizer(line, ",");
         
        // xử lí lần lượt các propos 
        String menuCode = st.nextToken().trim();
        String menuName = st.nextToken().trim();
        double price = Double.parseDouble(st.nextToken().trim());
        String ingredients = st.nextToken().trim();
       
        // đức ra object và trả ra object
        FeastMenu fm = new FeastMenu(menuCode, menuName, price, ingredients);
        return fm;
    }
     

    // hàn đọc file 
     public void readFromFile(){
         File f = new File("D:\\Lab211\\lab2\\FeastMenu.csv");
         if (!f.exists()) {
            System.out.println("file not exist!!!");
        }
         try {
             BufferedReader reader = new BufferedReader(new FileReader(f));
             String line = reader.readLine();
             line = reader.readLine();
             while(line != null){
                FeastMenu fm = dataToObject(line);
                
                 if(fm != null){
                     feaMenu.add(fm);
                 }
                 line = reader.readLine();
             }
             reader.close();
         } catch (Exception e) {
             System.out.println("File lỗi rồi " + e);
         }
     }


     
     public ArrayList<FeastMenu> sortAcsByPrice(ArrayList<FeastMenu> menuList){
         ArrayList<FeastMenu> tmp = new ArrayList<>(menuList);
         
         // sắp xép danh sách dựa vào price 
         Comparator orderByPrice = new Comparator<FeastMenu>() {
             @Override
             public int compare(FeastMenu t1, FeastMenu t2) {
                 return t1.getPrice() > t2.getPrice() ? 1 : -1;
             }
         };
         Collections.sort(tmp, orderByPrice);
         return tmp;
     }
     
    public void displayFeastMenus(ArrayList<FeastMenu> menuList) {
         ArrayList<FeastMenu> tmp = new ArrayList<>(menuList);
        String str = String.format(
        "|------------------------------------------------------------------|\n"
        +"              List of Set Menus for ordering party:\n"
        +"|------------------------------------------------------------------|\n");

        System.out.println(str);
        
        for (FeastMenu fm : tmp) {
            StringTokenizer st = new StringTokenizer(fm.getIngredients(), "#");
            String appetizer = st.nextToken().trim().substring(1);
            String mainCourse = st.nextToken().trim();
            String desert = st.nextToken().trim();
            String updateDesrt = desert.substring(0, desert.length() - 1);
            DecimalFormat formatter = new DecimalFormat("#,###,### vnd");
            String formattedFee = formatter.format(fm.getPrice());
            String str2 = String.format(
                    "Code: %s\n"
                    + "Name: %s\n"
                    + "Price: %s\n"
                    + "Ingredients:\n"
                    + "  %s\n"
                    + "   %s\n"
                    + "   %s\n"
                    + "------------------------------------------------------",
                    fm.getMenuCode(), fm.getMenuName(), formattedFee, appetizer, mainCourse, updateDesrt);
            System.out.println(str2);

        }
    }
    
   
    
    
   
}
