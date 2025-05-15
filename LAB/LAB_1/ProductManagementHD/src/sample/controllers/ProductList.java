package sample.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
import java.util.ArrayList;
import java.util.List;
import sample.dto.CeramicProduct;
import sample.dto.ElectricProduct;
import sample.dto.FoodProduct;
import sample.dto.I_List;
import sample.dto.Product;
import sample.utils.Utils;

public class ProductList extends ArrayList<Product> implements I_List {

    @Override
    public boolean add() {
        boolean check = false;
        boolean continous = false;
        try {
            String code = "";
            do {
                continous = false;
                code = Utils.getString("Input code: ");
                if (this.indexOf(new FoodProduct("", "", code, "", "", 0)) != -1) {
                    continous = true;
                }
            } while (continous);

            System.out.println("1. Create Ceramic Product.");
            System.out.println("2. Create Electric Product.");
            System.out.println("3. Create Food Product.");
            int choice = Utils.getInt("Input your choice: ", 0, 4);
            Product product = new CeramicProduct();
            switch (choice) {
                case 1:
                    product = new CeramicProduct();

                    break;
                case 2:
                    product = new ElectricProduct();

                    break;
                case 3:
                    product = new FoodProduct();

                    break;
            }
            product.setCode(code);
            product.create();
            this.add(product);
            check = true;
        } catch (Exception e) {
        }
        return check;
    }

    @Override
    public void diplay() {
        for (Product product : this) {
            product.display();

        }
    }

    @Override
    public Object remove(String code) {
        Object deletedObject = null;
//        for (Product product : this) {
//            if(product.getCode().equals(code)){
//                deletedObject= product;
//                this.remove(deletedObject);
//                break;
//            }
//        }
        int index = this.indexOf(new ElectricProduct(code));
        if (index != -1) {
            deletedObject = this.remove(index);
        }
        return deletedObject;
    }

    @Override
    public List<Object> searchByName(String name) {
        List<Object> listProduct= new ArrayList<>();
        for (Product product : this) {
            if(product.getName().toUpperCase().contains(name.toUpperCase())){
                listProduct.add(product);
            }
        }
        return listProduct;
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
