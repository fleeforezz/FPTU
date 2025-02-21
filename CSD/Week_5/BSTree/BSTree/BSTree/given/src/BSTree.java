import java.io.*;
import java.util.*;

public class BSTree {
    Node root;
    
    // Default constructor
    BSTree() {
        this.root = null;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public void clear() {
        this.root = null;
    }
    
    public void visit(Node p) {
        System.out.print("p.info: ");
        if(p != null) System.out.println(p.getInfo() + " ");
    }
    
    public void fvisit(Node p, RandomAccessFile f) throws Exception {
        if(p != null) 
            f.writeBytes(p.getInfo() + " ");
    }
    
    public void breadth(Node p, RandomAccessFile f) throws Exception {
        if(p == null) 
            return;
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while(!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r,f);
            
            if(r.left != null) 
                q.enqueue(r.left);
            
            if(r.right != null) 
                q.enqueue(r.right);
        }
    }
    
    public void preOrder(Node p, RandomAccessFile f) throws Exception {
        
        if(p == null) 
            return;
        
        fvisit(p,f);
        preOrder(p.left,f);
        preOrder(p.right,f);
    }
    
    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if(p == null) 
            return;
        
        inOrder(p.left,f);
        fvisit(p,f);
        inOrder(p.right,f);
    }
    
    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if(p == null) 
            return;
        
        postOrder(p.left,f);
        postOrder(p.right,f);
        fvisit(p,f);
     }


    void loadData(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        int [] b = Lib.readLineToIntArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);
        
        int n = a.length;
        for(int i=0;i<n;i++) 
            insert(a[i],b[i],c[i]); // insert the new Node(a[i], b[i], c[i]) into the BST
    }

    /**
    * Luy y: 1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh Error khi run chuong trinh.
    *        2. Neu khong tuan thu se nhan diem 0 (khong).

    * Question 1: use Bird’s ID as the key attribute when building a BST.
    *               implement the 'insert' method that inserts a new Node into 
    *               the BST if the attribute 'ID' of Bird is higher than zero (>0).
    * The output of this method will be written into the file 'f1.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: with the content given in the file 'data.txt', 
    *          the content of 'f1.txt' after insertion should be
    *           (A,7,9) (C,4,3) (B,9,4) (E,2,5) (Y,6,-7) (D,8,6) 
    *           (E,2,5) (C,4,3) (Y,6,-7) (A,7,9) (D,8,6) (B,9,4)  

    */
    void insert(String xOwner, int xID, int xColor) {
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        
        root = insertRec(root, xOwner, xID, xColor);
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        
    } 
    
    Node insertRec(Node x, String xOwner, int xID, int xColor) {
        if (xID > 0) {
            Bird temp = new Bird(xOwner, xID, xColor);
            Node new_Node = new Node(temp);
            if (x == null) {
                x = new_Node;
            } else {
                if (xID > x.getInfo().getID()) {
                    x.right = insertRec(x.right, xOwner, xID, xColor);
                }
                if (xID < x.getInfo().getID()) {
                    x.left = insertRec(x.left, xOwner, xID, xColor);
                }
            }
        }
        return x;
    }
    

    /**
     * Do NOT modify this method
     * This is a helper method for writing data (node's info) stored in the BST to file 
     * @throws Exception 
     */
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        f.writeBytes("Breath first traverse: ");
        breadth(root,f);
        f.writeBytes("\r\n");
        
        f.writeBytes("Pre-Order: ");
        preOrder(root,f);
        f.writeBytes("\r\n");
        
        f.writeBytes("In-Order: ");
        inOrder(root,f);
        f.writeBytes("\r\n");
        
        f.writeBytes("Post-Order: ");
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }  
  
    // This method is used for Question 2
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        breadth(root,f);
        f.writeBytes("\r\n");

        //Question 2: Dem so luong Node
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        
        System.out.println("Number of nodes: " + countNodes(root));
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        
        f.writeBytes("\r\n");
        f.close();
    }  
    
    int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    
    // This method is used for Question 3
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        postOrder(root,f);
        f.writeBytes("\r\n");
        /**
         * Question 3: Tinh chieu cao cua BST
         */
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        
     
	 int result = callHeightRec(root);
         f.writeBytes("height of the tree: " + result + "\r\n");
	 
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        
        postOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }  
    
    int callHeightRec(Node x) {
        if (x == null) {
            return 0;
        }
        if (x.left == null && x.right == null) {
            return 1;
        }
        if (callHeightRec(x.left) > callHeightRec(x.right)) {
            return callHeightRec(x.left) + 1;
        } else {
            return callHeightRec(x.right) + 1;
        }
    }

   
    
    // This method is used for Question 4
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        postOrder(root,f);
        f.writeBytes("\r\n");
        /**
         * Question 4: Gia su gia ban (price) cua moi object Bird duoc tinh bang ID 
         * Hay tinh gia ban trung binh cua tat ca cac object Bird co trong cay BST
         */
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        
        float result = (float)sumRec(root)/countNodes(root);
        f.writeBytes("Average price of the tree: " + result + "\r\n");
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        postOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }  
    
    int sumRec(Node x) {
        if (x == null) {
            return 0;
        } else {
            return sumRec(x.left) + sumRec(x.right) + x.getInfo().getID();
        }
        
    }
	
	// This method is used for Question 5
    void f5() throws Exception {
        clear();
        loadData(13);;
        String fname = "f5.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        postOrder(root,f);
        f.writeBytes("\r\n");
        
        //Question 5: Gia su gia ban (price) cua moi object Bird duoc tinh bang ID 
        //Hay tinh gia ban cao nhat cua cac object Bird co trong cay BST
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        f.writeBytes("Maximum price of the tree: " + temp.getInfo().getID());
       
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        postOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }  
	
	// This method is used for Question 6
    void f6() throws Exception {
        clear();
        loadData(13);;
        String fname = "f6.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        postOrder(root,f);
        f.writeBytes("\r\n");
        
        //Question 6: Co bao nhieu mau sac (color) khac nhau co trong cay BST 
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        
       
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        postOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }  
	
	// This method is used for Question 7
    void f7() throws Exception {
        clear();
        loadData(13);;
        String fname = "f7.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        postOrder(root,f);
        f.writeBytes("\r\n");
        
        //Question 7: Hay dem so luong node co ID > 5
        //---------------------------------------------------------------------------------------
        //------ Start your code here------------------------------------------------------------
        
        int result = countRec(root);
        f.writeBytes("Number of Nodes > 5: " + result);
       
        
        //------ End your code here--------------------------------------------------------------
        //---------------------------------------------------------------------------------------
        postOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }  
    
    int countRec(Node x) {
        Node temp = root;
        int count = 0;
        while (temp != null) {
            if (x == null) {
                return 0;
            }
            if (x.left.getInfo().getID() > 5) {
                count++;
            }
            if (x.right.getInfo().getID() > 5) {
                count++;
            }
        }
        return count;
    }
   

 }
