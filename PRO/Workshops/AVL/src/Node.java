/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
class Node {
    int key, height;
    Node left, right;

    public Node(int key) {
        this.key = key;
        this.height = 1; // Khi một nút mới được tạo, chiều cao ban đầu là 1
        this.left = this.right = null;
    }
}

