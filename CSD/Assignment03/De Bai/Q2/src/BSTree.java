/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        //System.out.println(p);
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xName, int xAge, int xId) {
        //You should insert here statements to complete this function
        root = insertRec(root, xName, xAge, xId);
    }

    Node insertRec(Node x, String xName, int xAge, int xId) {
        if (xId > 0) {
            User temp = new User(xName, xAge, xId);
            Node new_Node = new Node(temp);
            if (x == null) {
                x = new_Node;
            } else {
                if (xAge > 0) {
                    if (xId > x.info.id) {
                        x.right = insertRec(x.right, xName, xAge, xId);
                    }
                    if (xId < x.info.id) {
                        x.left = insertRec(x.left, xName, xAge, xId);
                    }
                }
            }
        }
        return x;
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        //------------------------------------------------------------------------------------
        postOrderFilterAge(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void postOrderFilterAge(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrderFilterAge(p.left, f);
        postOrderFilterAge(p.right, f);

        if (p.info.age < 25) {
            fvisit(p, f);
        }

    }

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        
        updateSingleChildNode(root);
        
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    void updateSingleChildNode(Node p) {
        if (p == null) return;
        
        boolean hasLeftNode = (p.left != null && p.right == null);
        boolean hasRightNode = (p.left == null && p.right != null);
        
        if (hasLeftNode || hasRightNode) {
            p.info.age += 3;
        }
        
        updateSingleChildNode(p.left);
        updateSingleChildNode(p.right);
    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        int h = 0;//Height of the last node
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        
        List <Node> tmp = new ArrayList();
        postOrder(root, tmp);
        h = heigh(tmp.get(tmp.size() -1));
        
        f.writeBytes(h + "");
        f.writeBytes("\r\n");
        f.close();
    }
    
    void postOrder(Node p, List tmp) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, tmp);
        postOrder(p.right, tmp);
        tmp.add(p);
    }

    int heigh(Node p) {
        if (p == null){
            return 0;
        }
        return 1 + Math.max(heigh(p.left), heigh(p.right));
    }

    
    int calcHeightLastNode(Node p) {
        if ( p == null ) {
            return 0;
        }
        if (p.left == null && p.right == null) {
            return 1;
        }
        if (calcHeightLastNode(p.left) > calcHeightLastNode(p.right)) {
            return calcHeightLastNode(p.left) + 1;
        } else {
            return calcHeightLastNode(p.right) + 1;
        }
    }

//=============================================================    
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        //------------------------------------------------------------------------------------
        resetAge(root.left);
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    void resetAge(Node p) {
        if (p == null) {
            return;
        }
        p.info.setAge(0);
        resetAge(p.left);
        resetAge(p.right);

    }
    
    Node findRightMost(Node p) {
        if (p == null) {
            return null;
        }
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

//=============================================================
    void f6() throws Exception {
        clear();
        loadData(21);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        Node right_most = null;//right_most node
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        
        Node rightMost = findRightMost(root);
        if (rightMost != null) {
            f.writeBytes(rightMost.info + "\r\n");
        }
        
        fvisit(right_most, f);
        f.writeBytes("\r\n");
        f.close();
    }
}
