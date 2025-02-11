
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverseFW(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info + "     "); // write data in the node p to the file f
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void ftraverseBW(RandomAccessFile f) throws Exception {
        Node p = tail;
        while (p != null) {
            f.writeBytes(p.info + "     "); // write data in the node p to the file f
            p = p.pre;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(a[i]);
            addLast(x);
        }
    }

    void addLast(int k) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node new_Node = new Node(k);
        if (head == null) {
            head = tail = new_Node;
        } else {
            tail.next = new_Node;
            new_Node.pre = tail;
            // dong lenh nay cuc ky quan trong
            tail = tail.next;
        }
        size++;
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
        ftraverseFW(f);
        ftraverseBW(f);
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
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Scanner input = new Scanner(System.in);
        System.out.println("\nNhap phan tu can them: ");
        int n = input.nextInt();

        Node new_Node = new Node(n);

        if (head == null) {
            head = tail = new_Node;
        } else {
            new_Node.next = head;
            head.pre = new_Node;
            head = new_Node;
        }
        size++;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f3: ham deleteThirdNode 
    // ==> xoa node thu ba cua list
    // gia su list co nhieu hon 3 phan tu
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node second_Node = head.next;
        Node fourth_Node = head.next.next.next;

        second_Node.next = fourth_Node;
        fourth_Node.pre = second_Node;

        size--;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

}
