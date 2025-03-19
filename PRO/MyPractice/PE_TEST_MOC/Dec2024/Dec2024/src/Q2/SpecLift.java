/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author jso
 */
public class SpecLift extends Lift {

    private int load;

    public SpecLift() {
    }

    public SpecLift(String label, int type, int load) {
        super(label, type);
        this.load = load;
    }

    public int getLoad() {
        return load;
    }
    
    public void setLoad(int load) {
        this.load = load;
    }

    public void setData(String lable) {
        
    }

    @Override
    public String toString() {
        return getLabel() + ", " + load + ", " + getType();
    }

}
