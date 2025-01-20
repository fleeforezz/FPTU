class Node{
    int info;
    Node next;
    Node pre;
    Node () {}
    Node (int x, Node p1, Node p2) {
        this.info = x; // data stored inside the node
        this.next = p1; // link to the next node
        this.pre = p2;
    }
    Node (int x) {
        this(x,null,null);
    }
 }

