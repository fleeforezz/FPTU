/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Category;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ADMIN
 */
public class CategoryRepo  {

    private List<Category> categories;
    public CategoryRepo(){
        categories= loadCategoryFromFile();
    }
    public List<Category> loadCategoryFromFile() {
        List<Category> categories = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/Category.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Giả sử dữ liệu trong file có dạng: id,name
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String id = parts[0].trim(); // Loại bỏ khoảng trắng thừa
                    String name = parts[1].trim();
                    categories.add(new Category(id, name));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categories;
    }

    
    public List<Category> getAllCategory() {
        return new ArrayList<>(categories);
    }

    public boolean isValidCategoryID(String catID) {
        for (Category category : categories) {
            if (category.getCategoryID().equalsIgnoreCase(catID.trim())) {  // Sử dụng equalsIgnoreCase để so sánh không phân biệt hoa thường
                return true;
            }
        }
        return false;
    }

}
