import java.util.ArrayList;

// Composite Design Pattern

interface Product {
    public void placeOrder();

    public void add(Product s);

    public void remove(Product s);

    public Product getChild(int i);

}

class Laptop implements Product {
    private String name;
    private int price;

    public Laptop(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void placeOrder() {
        System.out.println("Laptop " + name + " with price " + price + " is ordered");
    }

    public void add(Product s) {
        System.out.println("Cannot add to a Laptop");
    }

    public void remove(Product s) {
        System.out.println("Cannot remove from a Laptop");
    }

    public Product getChild(int i) {
        System.out.println("Cannot get child from a Laptop");
        return null;
    }
}

class Mobile implements Product {
    private String name;
    private int price;

    public Mobile(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void placeOrder() {
        System.out.println("Mobile " + name + " with price " + price + " is ordered");
    }

    public void add(Product s) {
        System.out.println("Cannot add to a Mobile");
    }

    public void remove(Product s) {
        System.out.println("Cannot remove from a Mobile");
    }

    public Product getChild(int i) {
        System.out.println("Cannot get child from a Mobile");
        return null;
    }
}

class Cart implements Product {
    private ArrayList<Product> children = new ArrayList<Product>();

    public void placeOrder() {
        System.out.println("Cannot place order for a Cart");
    }

    public void add(Product s) {
        children.add(s);
    }

    public void remove(Product s) {
        children.remove(s);
    }

    public Product getChild(int i) {
        return children.get(i);
    }
}

public class Task2 {
    public static void main(String[] args) {
        Product laptop1 = new Laptop("Dell", 50000);
        Product laptop2 = new Laptop("HP", 40000);
        Product mobile1 = new Mobile("Samsung", 20000);
        Product mobile2 = new Mobile("Apple", 50000);

        Product cart = new Cart();
        cart.add(laptop1);
        cart.add(laptop2);
        cart.add(mobile1);
        cart.add(mobile2);

        cart.getChild(0).placeOrder();
        cart.getChild(1).placeOrder();
        cart.getChild(2).placeOrder();
        cart.getChild(3).placeOrder();

    }
}