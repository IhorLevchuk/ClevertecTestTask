package bean;

import java.util.Objects;

public class Product {
    private final String name;
    private final int id;
    private final Byn price;
    private final boolean discount;

    public Product(int id, String name, Byn price, boolean discount) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Byn getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && discount == product.discount && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, price, discount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
