/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Brand;
import entities.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BrandRepo {

    private List<Brand> brands;

    public BrandRepo() {
        brands = loadBrandFromFile();
    }

    public List<Brand> loadBrandFromFile() {
        List<Brand> brands = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/Brand.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Giả sử dữ liệu trong file có dạng: id,name
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0].trim(); // Loại bỏ khoảng trắng
                    String name = parts[1].trim();
                    String location = parts[2].trim();
                    brands.add(new Brand(id, name, location));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return brands;

    }

//    public List<Brand> getAllBrands() {
//        return new ArrayList<>(brands);
//    }
    public boolean isValidBrandID(String brandID) {

        for (Brand brand : brands) {
            if (brand.getBrandID().equalsIgnoreCase(brandID.trim())) { // Sử dụng equalsIgnoreCase để so sánh không phân biệt hoa thường
                return true;
            }
        }
        return false;
    }

}
