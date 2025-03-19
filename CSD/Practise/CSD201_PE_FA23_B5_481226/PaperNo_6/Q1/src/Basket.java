// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
// == You can insert setters and/or getters only if you need them ==== 
class Basket {
  String maker;
  int type,radius;
  Basket() {
   }
  Basket(String xMaker, int xType, int xRadius){
    maker=xMaker;type=xType; radius=xRadius;
   }
  public String toString(){
    return("(" +maker+","+type + "," + radius + ")");
   }
 }
