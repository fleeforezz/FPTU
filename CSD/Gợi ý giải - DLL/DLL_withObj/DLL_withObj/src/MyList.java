
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
        Phone x = new Phone(id, name, price);
        // dong goi cac thong tin cua de bai thanh object Phone
        Node new_Node = new Node(x);
        // dong goi object Phone vao trong object Node
        if (head == null) {
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

        Scanner input = new Scanner(System.in);
        System.out.println("\nNhap ID: ");
        int id = input.nextInt();

        input.nextLine(); // dong code nay dung de loai bo ky tu \n con sot lai trong buffer
        System.out.println("\nNhap name: ");
        String name = input.nextLine();

        System.out.println("\nNhap price: ");
        int price = input.nextInt();

        Phone x = new Phone(id, name, price);
        Node new_Node = new Node(x);

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
    boolean isDuplicated(int id) {
        Node t = head;
        while (t != null) {
            if (t.info.ID == id) {
                return true; // ID da bi trung
            }
            t = t.next;
        }
        return false;
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
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
//        *** Người bình thường sẽ code như sau:
//		(1) viết code nhập dữ liệu
//		(2) đóng gói dữ liệu thành Phone và Node
//		(3) viết hàm phụ để check ID đã xuất hiện hay chưa
//		(4) xử lý và add vào vị trí ngay trước Node tail
//			(lưu ý: xử lý riêng các trường hợp:
//				- list rỗng
//				- list có 1 node)
//		(5) cập nhật size (nếu có add dữ liệu)

//	*** Người bất thường:
//		(1) if (không trùng):
//                      gọi lại hàm addLast()
//		(2) if (size>1):
//			swap(tail.info, tail.pre.info)
        Scanner input = new Scanner(System.in);
        System.out.println("\nNhap ID: ");
        int id = input.nextInt();

        input.nextLine(); // dong code nay dung de loai bo ky tu \n con sot lai trong buffer
        System.out.println("\nNhap name: ");
        String name = input.nextLine();

        System.out.println("\nNhap price: ");
        int price = input.nextInt();

        if (isDuplicated(id) == false) {
            Phone x = new Phone(id, name, price);
            Node new_Node = new Node(x);
            if (head == null) { // list rong
                head = tail = new_Node;
            } else {
                if (head == tail) {
                    // list co 1 phan tu
                    // tuong duong voi addFirst
                    new_Node.next = head;
                    head.pre = new_Node;
                    head = new_Node;
                } else {
                    // list co tu 2 node tro len
                    new_Node.next = tail;
                    new_Node.pre = tail.pre;

                    tail.pre.next = new_Node;
                    tail.pre = new_Node;
                }
            }
            size++;
        }
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
        if (head == tail) {
            // list rong hoac co 1 node
            head = tail = null;
            size = 0;
        } else {
            // list co tu 2 node tro len
            tail = tail.pre;
            tail.next = null;
            size--;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

    // f7: delete the duplicated nodes
    // two nodes are duplicated if their names and prices are the same
    // even if their IDs are different
    boolean isDuplicated_F7(String name, int price) {
        Node t = head;
        while (t != null) {
            if ((t.info.price == price) && (t.info.name.equals(name))) {
                return true; // ID da bi trung
            }
            t = t.next;
        }
        return false;
    }

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
//              *** Người bình thường:
//		(1) viết 1 hàm phụ ==> kiểm tra trùng
//		(2) duyệt từ đầu tới cuối list:
//			(a) nếu node không trùng thì để nguyên
//			(b) nếu node trùng thì xoá (và cập nhật size)
//			
//		*** Người bất thường:
//		(1) viết 1 hàm phụ ==> kiểm tra trùng
//		(2) tạo 1 list phụ, đặt tên XXX
//		(3) duyệt từ đầu tới cuối list:
//			nếu node không trùng XXX.addLast()
//		(4) gán lại dữ liệu từ XXX ==> list hiện tại

        MyList tmp = new MyList();
        Node t = head;
        while (t != null) {
            if (tmp.isDuplicated_F7(t.info.name, t.info.price) == false) {
                tmp.addLast(t.info.ID, t.info.name, t.info.price);
            }
            t = t.next;
        }
        head = tmp.head;
        tail = tmp.tail;
        size = tmp.size;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

}
