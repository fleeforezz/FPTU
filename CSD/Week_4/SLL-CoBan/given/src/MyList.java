
import java.util.*;
import java.io.*;

public class MyList {

    Node head;

    MyList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = null;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info + " "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }
    
    void ftraverseUsingFor(RandomAccessFile f) throws Exception {
        for (Node p = head; p != null; p = p.next) {
            f.writeBytes(p.info + " ");
        }
        f.writeBytes("\r\n");
    }
    
    void ftraverseRecurstion01(RandomAccessFile f, Node p) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
            ftraverseRecurstion01(f, p.next);
        }
    }
    
    void ftraverseRecurstion02(RandomAccessFile f, Node p) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
            ftraverseRecurstion01(f, p.next);
        }
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int n = a.length;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(a[i]);
            addLast(number);
        }
    }

    void addLast(int n) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        if (head == null) {
            head = new Node(n);
        } else {
            Node t = head;
            while (t.next != null) {                
                t = t.next;
            }
            t.next = new Node();
        }
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    // f1: ham nay se goi ham addLast nhieu lan
    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseRecurstion01(f, head);
        f.close();
    }

    // f2: ham addFirst ==> du lieu nhap tu ban phim
    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    int sumUsingWhile() {
        int s = 0;
        Node p = head;
        while (p != null) {
            s = s + p.info;
            p = p.next;
        }
        return s;
    }
    
    int sumUsingFor() {
        int s = 0;
        for (Node p = head; p != null; p = p.next) {
            s = s + p.info;
        }
        return s;
    }
    
    int sumUsingRecurstion(Node x) {
        if (x == null) {
            return 0;
        }
        return (x.info + sumUsingRecurstion(x.next));
    }
    
    // f3: ham addPos ==> them node vao vi tri thu k, trong do node moi va chi so k duoc nhap tu ban phim
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        
        int sum1 = sumUsingWhile();
        System.out.println(sum1);
        
        int sum2 = sumUsingFor();
        System.out.println(sum2);
        
        int sum3 = sumUsingRecurstion(head);
        System.out.println(sum3);
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f4: removeFirst
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f5: removeLast
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
