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
public class University extends Organization {

    protected String name;

    public University() {
    }

    public University(String name, int size) {
        super(size);
        this.name = name;
    }

    public void enroll() {
        System.out.println("The registration for enrollment is only valid\n"
                + "when the University has received all enrollment documents and enrollment fees");
    }

    public void educate() {
        System.out.println("provide education at university standard");
    }

    @Override
    public void communicateByTool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "University{" + "name=" + name + '}';
    }

}
