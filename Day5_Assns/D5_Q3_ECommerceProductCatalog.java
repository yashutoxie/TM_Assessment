import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

class Product {
    private int id;
    private String name;
    private double price;
    private Set<String> categories;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    @Override
    public String toString() {
        return "Product{ID=" + id + ", Name='" + name + "', Price=" + price + ", Catrgories= " + categories + "}";
    }
}

class PriceAscendingComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

class PriceDescendingComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p2.getPrice(), p1.getPrice());
    }
}

public class D5_Q3_ECommerceProductCatalog {
    private TreeMap<Integer, Product> productCatalog = new TreeMap<>();

    public void addProduct(Product p) {
        if (productCatalog.containsKey(p.getId())) {
            System.out.println("Product with ID: " + p.getId() + " already exists.");
        } else {
            productCatalog.put(p.getId(), p);
            System.out.println("Product added: " + p);
        }
    }

    public void displayAllProducts() {
        if (productCatalog.isEmpty()) {
            System.out.println("No products available.");
        } else {
            productCatalog.values().forEach(System.out::println);
        }
    }

    public void searchByPriceRange(double minPrice, double maxPrice) {
        System.out.println("Products in price Range: " + minPrice + " - " + maxPrice);
        productCatalog.values().stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .forEach(System.out::println);
    }

    public void sortByPriceAscending() {
        List<Product> sortedProducts = new ArrayList<>(productCatalog.values());
        sortedProducts.sort(new PriceAscendingComparator());
        sortedProducts.forEach(System.out::println);
    }

    public void sortByPriceDescending() {
        List<Product> sortedProducts = new ArrayList<>(productCatalog.values());
        sortedProducts.sort(new PriceDescendingComparator());
        sortedProducts.forEach(System.out::println);
    }

    public static void main(String[] args) {
        D5_Q3_ECommerceProductCatalog catalog = new D5_Q3_ECommerceProductCatalog();
        Product p1 = new Product(101, "Smartphone", 499.99);
        Product p2 = new Product(112, "Smartphone", 899.99);
        Product p3 = new Product(113, "Smartphone", 799.99);
        p1.addCategory("Mobile");
        p2.addCategory("Mobile");
        p3.addCategory("Mobile");

        catalog.addProduct(p1);
        catalog.addProduct(p2);
        catalog.addProduct(p3);
        System.out.println("\nAll Products: ");
        catalog.displayAllProducts();

        System.out.println("\nProducts in Price Range(200-600): ");
        catalog.searchByPriceRange(200, 600);

        System.out.println("\nProducts Sorted by price (Ascending order): ");
        catalog.sortByPriceAscending();

        System.out.println("\nProducts Sorted by price (Descending order): ");
        catalog.sortByPriceDescending();

    }
}
