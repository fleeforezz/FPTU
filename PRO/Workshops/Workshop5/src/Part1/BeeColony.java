/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part1;

/**
 *
 * @author jso
 */
public class BeeColony extends Colony implements Role {

    String type;

    public BeeColony(String type) {
        this.type = type;
    }

    public BeeColony(int size, String type, String place) {
        super(place, size);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "The colony's type is " + this.type + ", size is about " + getSize() + ", and the place is" + place;
    }

    @Override
    public void createWorker() {
        System.out.println("Worker bees perform all the work of the bees");
    }

}
