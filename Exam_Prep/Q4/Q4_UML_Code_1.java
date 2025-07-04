package Q4;

import java.sql.Date;

public class Q4_UML_Code_1 {

}

interface Shippable {
    void ship(String address);
}

interface Payable {
    void pay(double amount);
}

interface Refundable {
    boolean refund(String transactionID);
}

abstract class Order {
    protected String orderID;
    protected Date date;

    public Order(String orderID, Date date) {
        this.orderID = orderID;
        this.date = date;
    }

    public double calculateTotal() {
        System.out.println("Total");
        // as given UML logic vague, no value to return as a Total Price
        return 0.0;
    }

    public abstract void process();
}

abstract class Product {
    protected String id;
    protected String name;
    protected double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public abstract String getDetails();
}

class PhysicalProduct extends Product {
    public PhysicalProduct(String id, String name, double price) {
        super(id, name, price);
    }

    public String getDetails() {
        String outputString = String.format("%s: %s, price: %.2f", super.id, super.name, super.getPrice());
        // forgot to return the outputString
        return outputString;
    }
}

class Customer {
    protected String customerID;
    protected String name;

    public Customer(String ID, String name) {
        this.customerID = ID;
        this.name = name;
    }

    public String getContactInfo() {
        return this.customerID + this.name;
    }
}

class PhysicalOrder extends Order implements Shippable, Payable {
    protected double shippingCost;

    public PhysicalOrder(String id, Date date, double shippingCost) {
        super(id, date);
        this.shippingCost = shippingCost;
    }

    public void process() {
        System.out.println("Processing.");
    }

    public void ship(String address) {
        System.out.println("Shipping to" + address);
    }

    public void pay(double amount) {
        System.out.println("paid: " + amount);
    }
}

class SubscriptionOrder extends Order implements Payable, Refundable {
    protected int periodMonths;

    public SubscriptionOrder(String id, Date date, int periodMonths) {
        super(id, date);
        this.periodMonths = periodMonths;
    }

    public void process() {
        System.out.println("Processing");
    }

    public void pay(double amount) {
        System.out.println("Paid: " + amount);
    }

    public boolean refund(String id) {
        return true;
    }

}

class DigitalOrder extends Order implements Payable, Refundable {
    protected String downloadURL;

    public DigitalOrder(String id, Date date, String url) {
        super(id, date);
        this.downloadURL = url;
    }

    public void process() {
        System.out.println("Proccessing");
    }

    public void pay(double amount) {
        System.out.println("Paid: " + amount);
    }

    public boolean refund(String transactionID) {
        return true;
    }
}