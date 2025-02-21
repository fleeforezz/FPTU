// =========================================================
// Do NOT modify this file 
// =========================================================

class Bird {
    String owner;
    int ID,color;
    
    // Default constructure
    Bird () {}
    
    // Constructor with full parameter
    Bird (String xOwner, int xID, int xColor) {
        this.owner = xOwner;
        this.ID = xID; 
        this.color = xColor;
    }
    
    @Override
    public String toString(){
        return "(" +owner+","+ID + "," + color + ")";
    }

    public int getID() {
        return this.ID;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public void setColor(int inColor) {
        this.color = inColor;
    }
    
    public void setID(int inID) {
        this.ID = inID;
    }
    
    public void setOwner(String inOwner) {
        this.owner = inOwner;
    }
}