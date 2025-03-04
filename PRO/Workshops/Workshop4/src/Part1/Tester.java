/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part1;

import java.util.Scanner;

/**
 *
 * @author jso
 */
public class Tester {

    public static void main(String[] args) {
        ItemList obj = new ItemList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1. add a new vase");
            System.out.println("2. add a new statue");
            System.out.println("3. add a new painting");
            System.out.println("4. display all items");
            System.out.println("5. find the items by the creator ");
            System.out.println("6. update the item by its index");
            System.out.println("7. remove the item by its index");
            System.out.println("8. display the list of vase items ");
            System.out.println("9. sorts items in ascending order based on their values ");
            System.out.println("10. exit");
            System.out.println("input your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Item vase = new Vase();
                    vase.input();
                    if (obj.addItem(vase)) {
                        System.out.println("added");
                    }
                    break;
                case 2:
                    Item statue = new Statue();
                    statue.input();
                    if (obj.addItem(statue)) {
                        System.out.println("added");
                    }
                    break;
                case 3:
                    Item painting = new Painting();
                    painting.input();
                    if (obj.addItem(painting)) {
                        System.out.println("added");
                    }
                    break;
                case 4:
                    ItemList itemList = new ItemList();
                    itemList.displayAll();
                    break;
                case 5:
                    ItemList itemList_2 = new ItemList();
                    System.out.print("Enter creator: ");
                    String creator_raw = sc.nextLine();
                    itemList_2.findItem(creator_raw);
                    break;
                case 6:
                    ItemList itemList_3 = new ItemList();
                    System.out.print("Enter index to update: ");
                    int index_raw = sc.nextInt();
                    itemList_3.updateItem(index_raw);
                    break;
                case 7:
                    ItemList itemList_4 = new ItemList();
                    System.out.print("Enter index to remove: ");
                    int index_delete_raw = sc.nextInt();
                    itemList_4.removeItem(index_delete_raw);
                    break;
                case 8:
                    ItemList itemList_5 = new ItemList();
                    System.out.print("Enter type you want to display: ");
                    String type_raw = sc.nextLine();
                    itemList_5.displayItemByType(type_raw);
                    break;
                case 9:
                    ItemList itemList_6 = new ItemList();
                    itemList_6.sortItem();
                    break;

            }
        } while (choice <= 9);
    }
}
