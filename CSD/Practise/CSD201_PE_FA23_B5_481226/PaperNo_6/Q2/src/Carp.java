// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Carp {
  String river;
  int feature,weight;
  Carp() {
   }
  Carp(String xRiver, int xFeature, int xWeight){
    river=xRiver;feature=xFeature; weight=xWeight;
   }
  public String toString(){
    return("(" +river+","+feature + "," + weight + ")");
   }
 }
