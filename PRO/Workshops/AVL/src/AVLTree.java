/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class AVLTree {

    // Lấy chiều cao của một nút
    int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Trả về giá trị lớn hơn giữa hai số
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Tính Balance Factor (hệ số cân bằng)
    int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Thực hiện quay
        x.right = y;
        y.left = T2;

        // Cập nhật lại chiều cao
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Trả về nút mới
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Thực hiện quay
        y.left = x;
        x.right = T2;

        // Cập nhật lại chiều cao
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Trả về nút mới
        return y;
    }
    
    Node insert(Node node, int key) {
        // Bước 1: Thêm nút mới như cây BST bình thường
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // Không cho phép trùng key

        // Bước 2: Cập nhật chiều cao của nút hiện tại
        node.height = 1 + max(height(node.left), height(node.right));

        // Bước 3: Tính Balance Factor để kiểm tra mất cân bằng
        int balance = getBalance(node);

        // **Case 1: Mất cân bằng kiểu LL (Trái - Trái)**
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // **Case 2: Mất cân bằng kiểu RR (Phải - Phải)**
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // **Case 3: Mất cân bằng kiểu LR (Trái - Phải)**
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // **Case 4: Mất cân bằng kiểu RL (Phải - Trái)**
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Trả về node (không thay đổi nếu không cần quay)
        return node;
    }
    
    void printTree(Node root, int space) {
        if (root == null) return;
        space += 5;
        printTree(root.right, space);
        System.out.println(" " + root.key);
        printTree(root.left, space);
    }
}
