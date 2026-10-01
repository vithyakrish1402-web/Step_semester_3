package object_oriented_design.class_problems;

public class Product {

    private String productId;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.productId = name;
        this.name = name;
        this.price = price;
    }

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
