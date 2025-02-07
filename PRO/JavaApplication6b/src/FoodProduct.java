
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class FoodProduct extends Product {
    private Date date;
    private Date expireDate;

    public FoodProduct() {
    }

    public FoodProduct(String code, String name, String manufacturer, double price, Date date, Date expireDate) {
        super(code, name, manufacturer, price);
        this.date = date;
        this.expireDate = expireDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return super.toString() + date + ", " + expireDate;
    }
}
