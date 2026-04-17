import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Product {
    String name;
    double price;
    boolean inStock;

    // Constructor
    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    // toString method
    @Override
    public String toString() {
        return name + " - $" + price + " - " + (inStock ? "In Stock" : "Out of Stock");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create and populate list
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 800, true));
        products.add(new Product("Mouse", 25, true));
        products.add(new Product("Keyboard", 45, false));
        products.add(new Product("USB Cable", 10, true));
        products.add(new Product("Monitor", 150, true));

        // Predicate: price < 50 AND in stock
        Predicate<Product> isAffordable = p -> p.price < 50 && p.inStock;

        // Remove items that are NOT affordable
        products.removeIf(p -> !isAffordable.test(p));

        // Print result
        System.out.println("Filtered Products:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

    