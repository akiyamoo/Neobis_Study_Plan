package Model;

import java.util.Date;

public class Purchase {

    private int id;

    private int idCustomer;

    private int idProduct;

    private int countProduct;

    private Date date;

    public Purchase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

