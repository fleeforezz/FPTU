/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import repository.BrandRepo;
import repository.CategoryRepo;
import repository.ProductRepo;
import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class ProductService {

    Scanner sc = new Scanner(System.in, "UTF-8");
    private ProductRepo productRepo = new ProductRepo();
    private BrandRepo brandRepo = new BrandRepo();
    private CategoryRepo categoryRepo = new CategoryRepo();

    public boolean isEmpty() {
        return productRepo.isEmpty();
    }

    private void askToContinue(Runnable action) {
        String choice = Validation.getString("Do you want to continue or go back? ('y' to continue): ", "Answer cannot be empty.", false);
        if (choice.equalsIgnoreCase("y")) {
            action.run(); // Tiếp tục thực hiện hành động
        } else {
            System.out.println("Returning to main menu...");
        }
    }

    private String generateProductId() {
        // Lấy danh sách tất cả sản phẩm từ repository
        List<Product> products = productRepo.loadProductFromFile();

        if (products.isEmpty()) {
            return "P001"; // Nếu danh sách trống, ID đầu tiên là P001
        }

        int maxId = 0;
        for (Product p : products) {
            String numericPart = p.getProductID().substring(1);
            int id = Integer.parseInt(numericPart);
            if (id > maxId) {
                maxId = id;
            }
        }
        int newId = maxId + 1;
        return "P" + String.format("%03d", newId);
    }

    public void addProduct() {
        System.out.println("\n--- Create New Product ---");

        String id = generateProductId();
        System.out.println("Generated ID: " + id);
        String name;
        do {
            name = Validation.getString("Enter name[Name cannot be empty]:", "Name cannot be empty.", false);
            if (!name.matches("[\\p{L}\\s]+")) {
                System.out.println("Invalid input. Name must only contain letters. Please try again.");
                name = null;
            }
        } while (name == null);
        String brandId;
        do {
            brandId = Validation.getString("Enter brand ID[B001,B002]: ", "Brand ID cannot be empty.", false);
            if (!brandRepo.isValidBrandID(brandId)) {
                System.out.println("Brand ID does not exist. Please try again.");
            }
        } while (!brandRepo.isValidBrandID(brandId));

        String categoryId;
        do {
            categoryId = Validation.getString("Enter category ID[C001,C002]: ", "Category ID cannot be empty.", false);
            if (!categoryRepo.isValidCategoryID(categoryId)) {
                System.out.println("Category ID does not exist. Please try again.");
            }
        } while (!categoryRepo.isValidCategoryID(categoryId));
        int year = Validation.getInt("Enter model year[2020-2024]:", 2000, 2024, 3);
        int price = Validation.getInt("Enter list price[1-10000000]:", 1, 1000000, 3);
        Product newProduct = new Product(id, name, brandId, categoryId, year, price);
        productRepo.addProduct(newProduct);
        System.out.println("Product added successfully!");
        // Hiển thị và xác nhận thông tin sản phẩm
        System.out.println("\nReview Product Details:");
        System.out.println(newProduct);
        // Hỏi người dùng có muốn lưu sản phẩm vào file hay không
        String saveChoice;
        do {
            saveChoice = Validation.getString("Do you want to save this product to file? (y/n): ", "Please enter 'y' or 'n'.", false).toLowerCase();
            if (saveChoice.equalsIgnoreCase("y")) {
                productRepo.saveToFile();
                break;
            } else if (saveChoice.equalsIgnoreCase("n")) {
                System.out.println("Product will not be saved.");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'y' or 'n'.");
            }
        } while (true);
        askToContinue(() -> this.addProduct());
    }

    public void searchProduct() {
        while (true) {
            System.out.println("\n--- Search Products ---");
            System.out.println("1.Search product by name");
            System.out.println("2.Search product by id");
            System.out.println("3.Search product by BrandID");
            System.out.println("4.Search product by CategoryID");
            System.out.println("5.Search product by model year");
            System.out.println("6.Search product by price");
            System.out.println("0.Return to the menu");
            int choice = Validation.getInt("Enter your choice", 0, 6, 3);
            switch (choice) {
                case 1:
                    searchProductByName();
                    break;
                case 2:
                    searchProductByID();
                    break;
                case 3:
                    searchProductByBrandID();
                    break;
                case 4:
                    searchProductByCategoryID();
                    break;
                case 5:
                    searchProductByYear();
                    break;
                case 6:
                    searchProductByPrice();
                    break;
                case 0:
                    System.out.println("Returning to the menu...");
                    return;
            }
        }
    }

    // --- Function 2.1: Search Product by Name ---
    public void searchProductByName() {
        System.out.println("\n--- Search Product by Name ---");

        String searchName = Validation.getString("Enter a part of a product name to search: ", "Search term cannot be empty.", false);
        List<Product> products = productRepo.getProductByName(searchName);

        if (products == null || products.isEmpty()) {
            System.out.println("Have no any Product.");
        } else {
            products.sort((p1, p2) -> Integer.compare(p1.getModelYear(), p2.getModelYear()));  // Sort by model year ascending
            productRepo.printProductsFromFile(products);
        }

        askToContinue(this::searchProductByName);
    }

    // --- Function 2.2: Search Product by ID ---
    public void searchProductByID() {
        System.out.println("\n--- Search Product by ID ---");

        String searchID = Validation.getString(
                "Enter the Product ID to search: ",
                "Product ID cannot be empty.",
                false
        );

        Product product = productRepo.findProductByID(searchID);

        if (product == null) {
            System.out.println("No product found with ID: " + searchID);
        } else {
            System.out.println("Product found:");
            System.out.println(product);
        }
        askToContinue(this::searchProductByID);
    }

    public void searchProductByBrandID() {
        String brandID = Validation.getString("Enter Brand ID to search: ", "Brand ID must exists!", false);

        // Kiểm tra nếu BrandID hợp lệ hay không
        if (!brandRepo.isValidBrandID(brandID)) {
            System.out.println("Brand ID not found.");
            return;
        }

        // Lấy tất cả sản phẩm có cùng brandID
        List<Product> productsByBrand = productRepo.getProductsByBrandID(brandID);

        // Kiểm tra và hiển thị kết quả
        if (productsByBrand.isEmpty()) {
            System.out.println("No products found for the given Brand ID.");
        } else {
            System.out.println("Products under Brand ID " + brandID + ":");
            for (Product product : productsByBrand) {
                System.out.println(product);
            }
        }
    }

    public void searchProductByCategoryID() {
        String catID = Validation.getString("Enter Category ID to search: ", "Category ID must exists!", false);

        if (!categoryRepo.isValidCategoryID(catID)) {
            System.out.println("Category ID not found");
            return;
        }

        List<Product> productsByCategory = productRepo.getProductByCategoryID(catID);
        if (productsByCategory.isEmpty()) {
            System.out.println("No products found for the given CategoryID.");

        } else {
            System.out.println("Products with Category ID " + catID + ":");
            for (Product prods : productsByCategory) {
                System.out.println(prods);
            }
        }
    }

    // Tìm sản phẩm theo năm sản xuất
    public void searchProductByYear() {
        int year = Validation.getInt("Enter the year to search: ", 2000, 2024, 3); // Nhập năm
        List<Product> productsByYear = productRepo.getProductByYear(year);

        if (productsByYear.isEmpty()) {
            System.out.println("No products found for the given year.");
        } else {
            System.out.println("Products from the year " + year + ":");
            for (Product product : productsByYear) {
                System.out.println(product);
            }
        }
    }

    // Tìm sản phẩm theo giá
    public void searchProductByPrice() {
        int price = Validation.getInt("Enter the price to search: ", 1, 1000000, 3); // Nhập giá
        List<Product> productsByPrice = productRepo.getProductByPrice(price);

        if (productsByPrice.isEmpty()) {
            System.out.println("No products found for the given price.");
        } else {
            System.out.println("Products with the price " + price + ":");
            for (Product product : productsByPrice) {
                System.out.println(product);
            }
        }
    }

    public void updateProduct() {
        System.out.println("\n--- Update Product ---");

        Product existingProduct = null;
        String id;

        // Lặp đến khi người dùng nhập đúng ID
        do {
            id = Validation.getString("Enter product ID to update: ", "ID cannot be empty.", false);
            existingProduct = productRepo.findProductByID(id);
        } while (existingProduct == null);

        System.out.println("\nCurrent product details:");
        System.out.println(existingProduct);

        // Menu cập nhật
        System.out.println("\nChoose update mode:");
        System.out.println("1. Update entire product");
        System.out.println("2. Update specific fields");

        int choice = Validation.getInt("Enter your choice: ", 1, 2, 3);

        if (choice == 1) {
            updateEntireProduct(existingProduct);
        } else if (choice == 2) {
            updateSpecificFields(existingProduct);
        }
        productRepo.saveToFile();
        System.out.println("Product updated successfully!");

        askToContinue(this::updateProduct);
    }

    private void updateEntireProduct(Product existingProduct) {
        System.out.println("\n--- Update Entire Product ---");

        // Nhập tên sản phẩm mới
        String name = Validation.getString("Enter new name (current: " + existingProduct.getProductName() + "): ", "Input can be empty!", true).trim();
        if (!name.isEmpty()) {
            existingProduct.setProductName(name);
        }

        // Nhập Brand ID mới
        String brandId = Validation.getString("Enter new brand ID (current: " + existingProduct.getBrandID() + "): ", "", true).trim();
        if (!brandId.isEmpty()) {
            existingProduct.setBrandID(brandId);
        }

        // Nhập Category ID mới
        String categoryId = Validation.getString("Enter new category ID (current: " + existingProduct.getCategoryID() + "): ", "", true).trim();
        if (!categoryId.isEmpty()) {
            existingProduct.setCategoryID(categoryId);
        }

        // Nhập model year mới
        String yearInput = Validation.getString("Enter new model year (current: " + existingProduct.getModelYear() + "): ", "Input can be empty!", true).trim();
        if (!yearInput.isEmpty()) {
            int updatedYear = Integer.parseInt(yearInput);
            existingProduct.setModelYear(updatedYear);
        }

        // Nhập list price mới
        String priceInput = Validation.getString("Enter new list price (current: " + existingProduct.getListPrice() + "): ", "Input can be empty!", true).trim();
        if (!priceInput.isEmpty()) {
            int updatedPrice = Integer.parseInt(priceInput);
            existingProduct.setListPrice(updatedPrice);
        }
    }

    private void updateSpecificFields(Product existingProduct) {
        System.out.println("\n--- Update Specific Fields ---");

        while (true) {
            System.out.println("\nChoose a field to update:");
            System.out.println("1. Product Name");
            System.out.println("2. Brand ID");
            System.out.println("3. Category ID");
            System.out.println("4. Model Year");
            System.out.println("5. List Price");
            System.out.println("6. Exit");

            int fieldChoice = Validation.getInt("Enter your choice: ", 1, 6, 3);

            switch (fieldChoice) {
                case 1:
                    String name = Validation.getString("Enter new name (current: " + existingProduct.getProductName() + "): ", "Input can be empty!", true).trim();
                    if (!name.isEmpty()) {
                        existingProduct.setProductName(name);
                        System.out.println("Updated product details: " + existingProduct);
                    }
                    break;
                case 2:
                    String brandId = Validation.getString("Enter new brand ID (current: " + existingProduct.getBrandID() + "): ", "", true).trim();
                    if (!brandId.isEmpty()) {
                        existingProduct.setBrandID(brandId);
                        System.out.println("Updated product details: " + existingProduct);
                    }
                    break;
                case 3:
                    String categoryId = Validation.getString("Enter new category ID (current: " + existingProduct.getCategoryID() + "): ", "", true).trim();
                    if (!categoryId.isEmpty()) {
                        existingProduct.setCategoryID(categoryId);
                        System.out.println("Updated product details: " + existingProduct);
                    }
                    break;
                case 4:
                    String yearInput = Validation.getString("Enter new model year (current: " + existingProduct.getModelYear() + "): ", "Input can be empty!", true).trim();
                    if (!yearInput.isEmpty()) {
                        int updatedYear = Integer.parseInt(yearInput);
                        existingProduct.setModelYear(updatedYear);
                        System.out.println("Updated product details: " + existingProduct);
                    }
                    break;
                case 5:
                    String priceInput = Validation.getString("Enter new list price (current: " + existingProduct.getListPrice() + "): ", "Input can be empty!", true).trim();
                    if (!priceInput.isEmpty()) {
                        int updatedPrice = Integer.parseInt(priceInput);
                        existingProduct.setListPrice(updatedPrice);
                        System.out.println("Updated product details: " + existingProduct);
                    }
                    break;
                case 6:
                    System.out.println("Exiting field update menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //--- Delete product options(delete 1 or delete all products from the range user wants to delete
    public void deleteOptions() {
        System.out.println("\n--- Delete products ---");
        System.out.println("1.Delete 1 products.");
        System.out.println("2.Exit this function.");
        int choices = Validation.getInt("Enter your choice:", 1, 2, 3);
        switch (choices) {
            case 1:
                deleteProduct();
                break;
            case 2:
                System.out.println("Returning to the main menu...");
        }
    }

    // --- Function 4.1: Delete Product ---
    public void deleteProduct() {
        final String YELLOW = "\u001B[33m";
        System.out.println(YELLOW+">>> Press xxx to return to the main menu.");
        while (true) { 
            Product existingProduct = null;
            String id;
            do {
                id = Validation.getString("Enter product ID to delete: ", "ProductID must exist!", false);
                if (id.equalsIgnoreCase("xxx")) {
                    System.out.println("Returning to the main menu...");
                    return;
                }
                existingProduct = productRepo.findProductByID(id);
            } while (existingProduct == null); // Lặp lại nếu ID không tồn tại

            // Hiển thị thông tin sản phẩm trước khi xóa
            System.out.println("\n--- Product to Delete ---");
            System.out.println(existingProduct);

            String confirm;
            do {
                confirm = Validation.getString("Are you sure you want to delete this product? (y/n): ", "Answer cannot be empty.", false);
                if (confirm.equalsIgnoreCase("xxx")) {
                    System.out.println("Returning to the main menu...");
                    return; // Thoát về menu chính
                }
                if (confirm.equalsIgnoreCase("y")) {
                    if (productRepo.deleteProduct(id)) {
                       System.out.println("Product deleted successfully!");
                    } else {
                        System.out.println("Failed to delete product.");
                    }
                    break; // Kết thúc nếu xóa thành công hoặc thất bại
                } else if (confirm.equalsIgnoreCase("n")) {
                    System.out.println("Delete operation cancelled.");
                    break; // Kết thúc nếu người dùng chọn không xóa
                } else {
                    System.out.println("Invalid input. Please answer 'y' or 'n'.");
                }
            } while (true);

            // Hỏi người dùng xem có muốn tiếp tục xóa không
            String continueDeleting;
            do {
                continueDeleting = Validation.getString("Do you want to delete another one? (y/n): ", "Answer cannot be empty.", false);
                if (continueDeleting.equalsIgnoreCase("xxx")) {
                    System.out.println("Returning to the main menu...");
                    return; // Thoát về menu chính
                }
                if (continueDeleting.equalsIgnoreCase("n")) {
                    System.out.println("Returning to the main menu...");
                    return; // Kết thúc và quay lại menu chính
                } else if (continueDeleting.equalsIgnoreCase("y")) {
                    break; // Tiếp tục vòng lặp chính để xóa thêm
                } else {
                    System.out.println("Invalid input. Please answer 'y', 'n', or 'xxx'.");
                }
            } while (true);
        }

    }

    // 5. save file
    public void saveFile() {
        productRepo.saveToFile();
        System.out.println("Save file succesfully!");
    }

    // 6. print all
    public void printAllProducts() {
        // Load products from file
        List<Product> products = productRepo.loadProductFromFile();

        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Products loaded successfully from src/data/Product.txt");
            // Now print the loaded products
            productRepo.printProductsFromFile(products); // Pass loaded products to print method
        }
    }

}
