import java.util.ArrayList;

// Singleton Design Pattern

class ShopCart {
    private static ShopCart cart;
    private ArrayList<String> cartItems = new ArrayList<>();

    private ShopCart() {
    }

    public static ShopCart getCart() {
        if (cart == null) {
            cart = new ShopCart();
        }
        return cart;
    }

    public void addToCart(String item) {
        cartItems.add(item);
    }

    public void getCartList() {
        System.out.println("\nCart Items List\n");
        System.out.println("------------");
        for (String item : cartItems) {
            System.out.println(item);
        }
    }
}

public class Question2 {
    public static void main(String[] args) {
        ShopCart shop1 = ShopCart.getCart();

        shop1.addToCart("Dell Laptop");
        shop1.addToCart("Logitech Mouse");
        shop1.addToCart("Logitech Keyboard");
        shop1.addToCart("Kia Desk");

        shop1.getCartList();
    }
}
