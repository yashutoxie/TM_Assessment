public class D2_Q1_ProductPriceName {
    public static void main(String[] args) {
        product p1 = new product("Laptop", 60000);
        product p2 = new product("Laptop", 60000);
        System.out.println(p1.equals(p2));

    }
}

class product {
    private String name;
    private double price;

    product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static String getName(String name) {
        return name;
    }

    public static double getPrice(double price) {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        product p = (product) obj;
        return Double.compare(p.price, price) == 0 && name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + Double.hashCode(price);
    }
}
