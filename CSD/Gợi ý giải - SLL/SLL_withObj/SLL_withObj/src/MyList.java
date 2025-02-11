
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

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(b[i]);

            addLast(a[i], p);
        }
    }

    void addLast(String n, float p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone data = new Phone(n, p);
        Node tmp_Node = new Node(data);

        if (head == null) {
            head = tail = tmp_Node;
        } else {
            tail.next = tmp_Node;
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
        ftraverse(f);
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
        //(1) nhập dữ liệu: name và price

        Phone data = new Phone("FPT_Phone", 100);
        Node new_Node = new Node(data);

        if (head == null) {
            head = tail = new_Node;
        } else {
            new_Node.next = head;
            head = new_Node;
        }
        size++;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
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

    // f5: discount all Phone 'S' with 10%
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

        Node t = head;
        while (t != null) {
            if (t.info.name.equals("S")) {
                t.info.price *= 0.9;
            }
            t = t.next;
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // tinh gia tien (price) trung binh cua cac dien thoai
    void f6() throws Exception {
        clear();
        loadData(0);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        float s = 0;
        Node t = head;
        while (t != null) {
            s = s + t.info.price;
            t = t.next;
        } // vong lap while: tinh tong so tien trong list
        float avgPrice = s / size;
        f.writeBytes(avgPrice + "\n"); // write data 

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // dem so luong dien thoai "I" co trong list
    void f7() throws Exception {
        clear();
        loadData(0);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        int count = 0;
        Node t = head;
        while (t != null) {
            if (t.info.name.equals("I")) {
                count++;
            }
            t = t.next;
        }
        f.writeBytes(count + "\n"); // write data 
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // dem so luong cac loai dien thoai khac nhau co trong list
    void f8() throws Exception {
        clear();
        loadData(0);
        String fname = "f8.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        int count = 0;
        Node x = head;
        while (x != null) {
            Node tmp = head;
            int isDuplicated = 0;
            while (tmp != x) {
                if (tmp.info.name.equals(x.info.name)) {
                    isDuplicated = 1;
                }
                tmp = tmp.next;
            }
            if (isDuplicated == 0) {
                count++;
            }
            x = x.next;
        }

        f.writeBytes(count + "\n"); // write data
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // giam gia 10% cho cac dien thoai co price>7
    void f9() throws Exception {
        clear();
        loadData(0);
        String fname = "f9.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node t = head;
        while (t != null) {
            if (t.info.price > 7) {
                t.info.price *= 0.9;
            }
            t = t.next;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // xoa tat ca dien thoai "S" co trong list
    void f10() throws Exception {
        clear();
        loadData(0);
        String fname = "f10.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        
//       Cach 01: Xet tu tu tung truong hop:        
//        if (head != null) {
//            while (head.info.name.equals("S")) {
//                head = head.next;
//            }
//        }
//
//        if (head != null && head.next != null) {
//            Node t = head;
//            while (t!= null && t.next != null) {
//                if (t.next.info.name.equals("S")) {
//                    t.next = t.next.next;
//                }
//                t = t.next;
//            }
//        }

//       Cach 02: lat nguoc van de
//                - khong "xoa" cac gia tri S
//                - ma chung ta sẽ "loc" cac gia tri khac S
//                - va sau do dua nhung ket qua nay vao mot list moi
//                - cuoi cung, chuyen du lieu tu list moi sang list cu
        MyList tmp = new MyList();
        Node t = head;
        while (t != null) {
            if (!t.info.name.equals("S")) { // dong code nay la quan trong nhat
                tmp.addLast(t.info.name, t.info.price);
            }
            t = t.next;
        }
        this.head = tmp.head;
        this.tail = tmp.tail;
        this.size = tmp.size;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
