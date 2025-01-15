
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
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        f.writeBytes("So luong Node: " + count);
        f.writeBytes("\r\n");
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    boolean isExists(int n, Node t) {
        // Ham kiem tra gia tri n
        // da xuat hien trong khoan tu head den trc node t hay chua
        Node x = head;
        while (t != null && x != t) {
            if (x.info == n) {
                return true;
            }
            x = x.next;
        }
        return false;
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
        Node p = head;
        while (p != null) {
            if (!isExists(p.info, p)) {
                count++;
            }
            p = p.next;
        }

        f.writeBytes("So luong phan tu khac nhau: " + count);
        f.writeBytes("\r\n");
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

        //xoa max:
        // tim max
        
        Node p = head;
        while (p != null) {
            if ()
            p = p.next;
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

        // Doi cho min va max
        // -b1: tim min
        // -b2: tim max
        // -b3: doi cho
        //      int k
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
