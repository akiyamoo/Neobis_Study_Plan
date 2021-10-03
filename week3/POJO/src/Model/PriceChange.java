package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PriceChange {

    private int idProduct;

    private int price;

    private Date date;

    public PriceChange(){}

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
