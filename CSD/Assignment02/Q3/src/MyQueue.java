
import java.util.*;
import java.io.*;

public class MyQueue {

    Node head, tail;
    Node ehead, etail;
    int size;

    MyQueue() {
        this.head = null;
        this.tail = null;
        this.ehead = null;
        this.etail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.ehead = null;
        this.etail = null;
        this.size = 0;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = ehead;
        f.writeBytes("Emergency:     ");
        while (p != null) {
            f.writeBytes(p.info.name + "-" + p.info.eLevel + "     "); // write data in the node p to the file f
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.writeBytes("Normal:     ");
        p = head;
        while (p != null) {
            f.writeBytes(p.info.name + "-" + p.info.eLevel + "     "); // write data in the node p to the file f
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

            enQueue(a[i], p);
        }
    }

    void enQueue(String n, float p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Patient new_Patient = new Patient(n, p);
        Node new_Node = new Node(new_Patient);

        if (p > 5) {
            if (ehead == null) {
                ehead = etail = new_Node;
            } else {
                etail.next = new_Node;
                etail = new_Node;
            }
        } else {
            if (head == null) {
                head = tail = new_Node;
            } else {
                tail.next = new_Node;
                tail = new_Node;
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
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Node emerNode = ehead;
        int emer_Counter = 0;

        Node normNode = head;
        int norm_Counter = 0;

        if (isEmpty()) {
            return;
        } else {
            while (emerNode != null) {
                emer_Counter++;
                emerNode = emerNode.next;
            }

            while (normNode != null) {
                norm_Counter++;
                normNode = normNode.next;
            }
        }

        System.out.println("Number of Emergency patients: " + emer_Counter);
        System.out.println("Number of Normal patients: " + norm_Counter);

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
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        if (ehead != null) {
            f.writeBytes(ehead.info.name + "-" + ehead.info.eLevel + "\r\n");
            ehead = ehead.next;
            size--;
        } else {
            f.writeBytes(head.info.name + "-" + head.info.eLevel + "\r\n");
            head = head.next;
            size--;
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
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
        
        while (size != 0) {
            if (ehead != null) {
                f.writeBytes("Patient (Emergency): " + ehead.info.name + "-" + ehead.info.eLevel + "\r\n");
                ehead = ehead.next;
                size--;
            } else {
                f.writeBytes("Patient: " + head.info.name + "-" + head.info.eLevel + "\r\n");
                head = head.next;
                size--;
            }
        }
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
