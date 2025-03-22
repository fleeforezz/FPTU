
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

    // Luu y: doc ky dieu kien trong de bai
    void addLast(String n, float p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Phone data = new Phone(n, p);

        Node tmp_Node = new Node(data);

        if (head == null) {
            head = tail = tmp_Node;
        } else {
            if (data.price <= 0) {
                System.out.println("Phone price must be > 0");
            } else {
                tail.next = tmp_Node;
                tail = tail.next;
            }
        }
        size++;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

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

    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        Phone t = new Phone("FPT_Phone", 100);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Node new_node = new Node(t);

        Node current = head;
        Node prev = null;
        Node maxPrev = null;
        Node maxNode = null;
        float maxPrice = Float.MIN_VALUE;

        if (current == null) {
            head = tail = new_node;
        } else {
            while (current != null) {
                if (current.info.price > maxPrice) {
                    maxPrice = current.info.price;
                    maxPrev = prev;
                    maxNode = current;
                }
                prev = current;
                current = current.next;
            }

            if (maxNode != null) {
                if (maxPrev == null) {
                    new_node.next = head;
                    head = new_node;
                } else {
                    maxPrev.next = new_node;
                    new_node.next = maxNode;
                }
                size++;
            }
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        float avg_S = 0;
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Node h = head;

        float sum = 0;
        int count = 0;

        while (h != null) {
            if (h.info.name.equals("S")) {
                sum += h.info.price;
                count++;
            }
            h = h.next;
        }

        if (count == 0) {
            avg_S = 0;
        } else {
            avg_S = sum / count;
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.writeBytes(avg_S + "\n"); // write data
        ftraverse(f);
        f.close();
    }

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

        Phone phone = new Phone("yay", 1);

        Node m = head;
        Node temp;
        int position = 3;
        int step = position - 2;

        while (step > 0) {
            m = m.next;
            step -= 1;
        }

        Node node_N = new Node(phone);
        node_N.next = m.next;
        m.next = node_N;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

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
