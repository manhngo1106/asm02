//import java.io.*;
//import java.util.*;
//
//class Product {
//    
    import java.io.Serializable;

class Product implements Serializable {
    String pcode;
    String pro_name;
    int quantity;
    int saled;
    double price;

    Product(String pcode, String pro_name, int quantity, int saled, double price) {
        this.pcode = pcode;
        this.pro_name = pro_name;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pcode='" + pcode + '\'' +
                ", pro_name='" + pro_name + '\'' +
                ", quantity=" + quantity +
                ", saled=" + saled +
                ", price=" + price +
                '}';
    }

    void setQuantity(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}