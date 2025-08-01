/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author jso
 */
public class customers implements Serializable, Comparable<customers> {

    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private String phone;
    private String email;

    public customers() {

    }

    public customers(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(customers o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    /*
        #####################
        Display Customer Info
        #####################
     */
    public String display() {
        return String.format("""
                             %-8s | %-24s | %-13s | %-12s
                             """,
                this.id, this.name, this.phone, this.email
        );
    }
}
