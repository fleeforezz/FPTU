/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part1;

/**
 *
 * @author jso
 */
public class ItemList {

    private Item[] list;
    private int numberOfItems;
    private int MAX = 100;

    public ItemList() {
        list = new Item[MAX];
        numberOfItems = 0;
    }

    public Item[] getList() {
        return list;
    }

    public void setList(Item[] list) {
        this.list = list;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public int getMAX() {
        return MAX;
    }

    public void setMAX(int MAX) {
        this.MAX = MAX;
    }

    public boolean addItem(Item item) {
        if (item == null || numberOfItems >= MAX) {
            return false;
        }
        list[numberOfItems] = item;
        numberOfItems++;
        return true;
    }

    public void displayAll() {
        if (numberOfItems == 0) {
            System.out.println("The list is empty");
        }

        for (int i = 0; i < numberOfItems; i++) {
            System.out.println(list[i]);
        }
    }

    public Item findItem(String creator) {
        for (Item item : list) {
            if (item.getCreator().equals(creator)) {
                return item;
            }
        }

        return null;
    }

    public int findItemIndex(String creator) {
        for (int i = 0; i < numberOfItems; i++) {
            Item item = list[i];
            if (item.getCreator().equals(creator)) {
                return i;
            }
        }

        return -1;
    }

    public boolean updateItem(int index) {
        if (index >= 0 && index < numberOfItems) {
            list[index].input();
            return false;
        }
        return true;
    }

    public boolean removeItem(int index) {

        if (index >= 0 && index < numberOfItems) {
            for (int i = index; i < numberOfItems; i++) {
                list[i] = list[i + 1];
            }
            numberOfItems--;
            return true;
        }

        return false;
    }

    public void displayItemByType(String type) {
        for (Item item : list) {

            if (type.equals("Vase") && (item instanceof Vase)) {
                System.out.println(item);
            }

            if (type.equals("Statue") && (item instanceof Statue)) {
                System.out.println(item);
            }

            if (type.equals("Painting") && (item instanceof Painting)) {
                System.out.println(item);
            }
        }
    }

    public void sortItem() {
        for (int i = 0; i < numberOfItems; i++) {
            for (int j = numberOfItems - 1; j > i; j--) {
                if (list[i].getValue() < list[j - 1].getValue()) {
                    Item tmp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = tmp;
                }
            }
        }
    }
}
