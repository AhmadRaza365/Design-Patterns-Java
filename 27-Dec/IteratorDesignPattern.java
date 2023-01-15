// Iterator Design Pattern
// Date: 27-12-2022

import java.util.ArrayList;

interface Iterator {
    public boolean hasNextItem();

    public Object next();
}

interface Container {
    public Iterator getIterator();
}

class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class ProductCollection implements Container {
    public ArrayList<Product> products = new ArrayList<Product>();

    public ProductCollection() {
        products.add(new Product("Laptop", 90000));
        products.add(new Product("Mobile", 20000));
        products.add(new Product("Watch", 5000));
    }

    @Override
    public Iterator getIterator() {
        return new ProductIterator();
    }

    private class ProductIterator implements Iterator {

        int index;

        @Override
        public boolean hasNextItem() {
            if (index < products.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNextItem()) {
                return products.get(index++);
            }
            return null;
        }
    }
}

public class IteratorDesignPattern {
    public static void main(String[] args) {
        ProductCollection products = new ProductCollection();

        for (Iterator iter = products.getIterator(); iter.hasNextItem();) {
            Product product = (Product) iter.next();
            System.out.println("Product : " + product.getName() + ", Price : " + product.getPrice());
        }
    }
}
