/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Brand;
import entities.Category;
import entities.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ProductRepo {

    private List<Product> products;
    private static final String FILE_PRO = "src/data/Product.txt";
    private final BrandRepo brandRepo = new BrandRepo();
    private final CategoryRepo categoryRepo = new CategoryRepo();

    public ProductRepo() {
        products = loadProductFromFile(); // Tải dữ liệu từ file vào danh sách products khi khởi tạo
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product updateProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID().equals(updateProduct.getProductID())) {
                products.set(i, updateProduct);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public boolean deleteProduct(String id) {
        Product product = findProductByID(id); // Tìm sản phẩm theo ID
        if (product != null) {
            products.remove(product);
            return true;
        }
        return false;
    }

    public List<Product> loadProductFromFile() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/Product.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String id = fields[0];
                String name = fields[1];
                String brandId = fields[2];
                String categoryId = fields[3];
                int modelYear = Integer.parseInt(fields[4]);
                int price = Integer.parseInt(fields[5]);

                products.add(new Product(id, name, brandId, categoryId, modelYear, price));
            }
        } catch (IOException e) {
            System.out.println("Error loading products from file: " + e.getMessage());
        }
        return products;
    }

    public Product findProductByID(String id) {
        for (Product product : products) {
            if (product.getProductID().equalsIgnoreCase(id)) {
                return product;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
        return null;
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PRO))) {
            for (Product product : products) {
                bw.write(String.format("%s,%s,%s,%s,%d,%d",
                        product.getProductID(),
                        product.getProductName(),
                        product.getBrandID(),
                        product.getCategoryID(),
                        product.getModelYear(),
                        product.getListPrice()));
                bw.newLine();
            }
            System.out.println("Products saved successfully to " + FILE_PRO);
        } catch (IOException e) {
            System.err.println("Error saving products to file: " + e.getMessage());
        }
    }

    public List<Product> getProductByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No products found matching the name: " + name);
        }
        return result;
    }

    public void printProductsFromFile(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        // Print header
        System.out.printf("%-10s %-30s %-20s %-20s %-10s %-10s%n",
                "ID", "Name", "Brand", "Category", "Year", "Price");

        // Print each product
        for (Product product : products) {
            String brandName = findBrandByName(brandRepo.loadBrandFromFile(), product.getBrandID());
            String categoryName = findCategoryByName(categoryRepo.loadCategoryFromFile(), product.getCategoryID());

            System.out.printf("%-10s %-30s %-20s %-20s %-10d %-10d%n",
                    product.getProductID(),
                    product.getProductName(),
                    brandName,
                    categoryName,
                    product.getModelYear(),
                    product.getListPrice());
        }
    }

    private String findBrandByName(List<Brand> brands, String brandId) {
        for (Brand brand : brands) {
            if (brand.getBrandID().equals(brandId)) {
                return brand.getBrandName();
            }
        }
        return "Unknown Brand";
    }

    private String findCategoryByName(List<Category> categories, String categoryId) {
        for (Category category : categories) {
            if (category.getCategoryID().equals(categoryId)) {
                return category.getCategoryName();
            }
        }
        return "Unknown Category";
    }

    public List<Product> getProductsByBrandID(String brandID) {
        List<Product> productsByBrand = new ArrayList<>();
        for (Product product : products) {
            if (product.getBrandID().equalsIgnoreCase(brandID.trim())) {
                productsByBrand.add(product);
            }
        }
        return productsByBrand;
    }

    public List<Product> getProductByCategoryID(String categoryID) {
        List<Product> productByCategory = new ArrayList<>();
        for (Product pro : products) {
            if (pro.getCategoryID().equalsIgnoreCase(categoryID.trim())) {
                productByCategory.add(pro);
            }
        }
        return productByCategory;
    }

    public List<Product> getProductByYear(int year) {
        List<Product> productByYear = new ArrayList<>();
        for (Product p : products) {
            if (p.getModelYear() == year) {  // So sánh năm sản xuất
                productByYear.add(p);
            }
        }
        return productByYear;
    }

    public List<Product> getProductByPrice(int price) {
        List<Product> productByPrice = new ArrayList<>();
        for (Product p : products) {
            if (p.getListPrice() == price) {
                productByPrice.add(p);
            }
        }
        return productByPrice;
    }
}
