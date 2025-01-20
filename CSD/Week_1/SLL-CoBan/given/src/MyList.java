
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

        // Truong hop 1: list rong, chua co data
        if (isEmpty() == true) {
            head = new Node(n);
        } // Truong hop 2: List da co data
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(n);
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

        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        sca.nextLine();

        if (isEmpty() == true) {
            head = new Node(n);
        } else {
            Node temp = new Node(n);
            temp.next = head;
            head = temp;
        }

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
        Scanner sca = new Scanner(System.in);

        System.out.print("Nhap so can them: ");
        int inputNumber = sca.nextInt();

        System.out.print("Nhap vi tri them: ");
        int position = sca.nextInt();

        Node m = head;
        int step = position - 2;
        while (step > 0) {
            m = m.next;
            step -= 1;
        }

        Node node_N = new Node(inputNumber);
        node_N.next = m.next;
        m.next = node_N;

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
        if (head != null) {
            head = head.next;
        }

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

        Node t = head;
        while (t.next.next != null) {
            t = t.next;
        }
        
        t.next = null;
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
