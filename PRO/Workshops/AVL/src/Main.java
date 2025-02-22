/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Node root = null;

        // Chèn các phần tử vào cây AVL
        int[] keys = {30, 20, 40, 10, 25, 35, 50};
        for (int key : keys) {
            root = tree.insert(root, key);
        }

        // In cây sau khi chèn
        System.out.println("Cây AVL sau khi chèn:");
        tree.printTree(root, 0);
    }
}
