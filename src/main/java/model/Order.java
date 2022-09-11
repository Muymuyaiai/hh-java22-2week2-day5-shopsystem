package model;

import java.util.ArrayList;
import java.util.Set;

public class Order {
    private int orderId;
    private ArrayList<Product> products;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Order(int orderId, ArrayList<Product> products) {
        this.orderId = orderId;
        this.products = products;
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
