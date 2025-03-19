// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
// == You can insert setters and/or getters only if you need them ==== 
class Node {
  Basket info;
  Node next;
  Node() {
   }
  Node(Basket x, Node p) {
    info=x;next=p;
   }
  Node(Basket x) {
    this(x,null);
   }
 }

