
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
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void ftraverseBW(RandomAccessFile f) throws Exception {
        Node p = tail;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.pre;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        String[] c = Lib.readLineToStrArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(a[i]);
            int y = Integer.parseInt(c[i]);
            addLast(x, b[i], y);
        }
    }

    void addLast(int id, String name, int price) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Phone phone = new Phone(id, name, price);
        Node new_Node = new Node(phone);
        
        if (isEmpty()) {
            head = tail = new_Node;
        } else {
            tail.next = new_Node;
            new_Node.pre = tail;
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
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter ID: ");
        int id_raw = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name_raw = sc.nextLine();
        System.out.print("Enter price: ");
        int price_raw = sc.nextInt();
        
        Phone phone = new Phone(id_raw, name_raw, price_raw);
        Node new_Node = new Node(phone);
        
        if (isEmpty() == true) {
            head = tail = new_Node;
        } else {
            head.next = new_Node;
            head.next.pre = head;
            head = head.next;
        }
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f3: ham deleteThirdNode ==> xoa node thu ba cua list
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

        Node seccond = head.next;
        Node four = head.next.next.next;
        seccond.next = four;
        four.pre = seccond;
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f4: remove the all Phone 'I'
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        MyList tmp = new MyList();
        Node n = head;
        while (n != null) {
            if (!n.info.name.equals("I")) {
                tmp.addLast(n.info.ID, n.info.name, n.info.price);
            }
            n = n.next;
        }
        this.head = tmp.head;
        this.tail = tmp.tail;
        this.size = tmp.size;
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f5: add a new Phone to the possition "before the last node"
    // (only add if the list does not contain the ID of the new Phone).
    // This also means that: 
    // (1) you should check the ID of the new Phone exist in the list or not; 
    // (2) if it does not exist, you write your code to add it to the list.
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter ID: ");
        int id_raw = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name_raw = sc.nextLine();
        System.out.print("Enter price: ");
        int price_raw = sc.nextInt();
        
        Phone phone = new Phone(id_raw, name_raw, price_raw);
        Node new_Node = new Node(phone);
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f6: delete the last node 
    void f6() throws Exception {
        clear();
        loadData(0);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    boolean check_F7(Phone x) {
        Node p = head;
        while(p != null) {
            if (p.info.price == x.price && p.info.name.equals(x.name)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }
    
    // f7: delete the duplicated nodes
    // two nodes are duplicated if their names and prices are the same
    // even if their IDs are different
    void f7() throws Exception {
        clear();
        loadData(0);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        
        MyList tmp = new MyList();
        Node p = head;
        while(p!=null) {
            if (tmp.check_F7(p.info.ID, p.info))
        }
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

}
