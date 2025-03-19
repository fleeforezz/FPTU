package Q1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class House {

    private String type;
    private int area;

    public House() {
    }

    public House(String type, int area) {
        this.type = type;
        setArea(area);
    }

    public String getType() {
        String reversedString = "";
        if (type.length() >= 3) {
            type = type.substring(type.length() - 3);
        } else {
            return "Error";
        }
        
        for (int i = 0; i < type.length(); i++) {
            reversedString = type.charAt(i) + reversedString;
        }
        
        return reversedString;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        area = area * 3;
        this.area = area;
    }

}
