
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
        if (head == null) {
            head = new Node(n);
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = new Node(n);
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

        Scanner input = new Scanner(System.in);
        System.out.println("\nNhap phan tu can them: ");
        int n = input.nextInt();

        // Code ngan gon: head = new Node(n, head);
        if (head == null) {
            head = new Node(n);
        } else {
            Node t = new Node(n);
            t.next = head;
            head = t;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f3: ham addPos ==> them node vao vi tri thu pos
    // luu y: vi tri dau tien la vi tri thu 0
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
        Scanner input = new Scanner(System.in);
        System.out.println("\nNhap phan tu can them: ");
        int n = input.nextInt();

        input = new Scanner(System.in);
        System.out.println("\nNhap vi tri can them: ");
        int pos = input.nextInt();

//        if ((pos <0) || (pos> ...)) {
//            return;
//        }
        Node t = head;
        int count = 0;
        while (count < pos - 1) {
            t = t.next;
            count++;
        }
        // muc dich cua vong while:
        // tim node dung o vi tri (pos-1)

        Node x = new Node(n);
        x.next = t.next;
        t.next = x;

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

        if ((head == null) || (head.next == null)) {
            head = null;
        }
        Node x = head;
        while (x.next.next != null) {
            x = x.next;
        }
        x.next = null;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // tim kiem tat ca cac gia tri > 5, sau do xuat ket qua ra file 
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
        Node p = head;
        while (p != null) {
            if (p.info > 5) {
                f.writeBytes(p.info + " "); // write data in the node p to the file f
            }
            p = p.next;
        }

        f.writeBytes("\r\n");
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // dem so luong phan tu trong list bang 1 vong lap while
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
        Node x = head;
        while (x != null) {
            x = x.next;
            count++;
        }

        f.writeBytes(count + "\n"); // write data

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // dem so luong gia tri khac nhau trong list
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
                if (tmp.info == x.info) {
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

    // xoa phan tu lon nhat trong list
    // (gia su chi co duy nhat 1 phan tu lon nhat)
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
        Node max = head;
        Node t = head;
        while (t != null) {
            if (t.info > max.info) {
                max = t;
            }
            t = t.next;
        }
        if (max == head) {
            f4();
        } else {
            Node preMax = head;
            t = head;
            while (t != null) {
                if (t.next == max) {
                    preMax = t;
                    break;
                }
                t = t.next;
            }
            preMax.next = max.next;
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // doi cho phan tu lon nhat va nho nhat trong list
    // (gia su chi co 1 phan tu lon nhat va 1 phan tu nho nhat)
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
        Node max = head;
        Node t = head;
        while (t != null) {
            if (t.info > max.info) {
                max = t;
            }
            t = t.next;
        }

        Node min = head;
        t = head;
        while (t != null) {
            if (t.info < min.info) {
                min = t;
            }
            t = t.next;
        }

        int xxx = max.info;
        max.info = min.info;
        min.info = xxx;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
