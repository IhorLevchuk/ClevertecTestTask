package bean;


import enumeration.PurchaseTable;

import java.util.Objects;

public class Purchase {
    private final static int DISCOUNT_PERCENT = 10;
    private final static int NUMBER_FOR_DISCOUNT = 5;
    private final Byn worth;
    private final Byn netWorth;
    private final Product product;
    private final int unitsNumber;

    public Purchase(Product product, int unitsNumber) {
        this.product = product;
        this.unitsNumber = unitsNumber;
        this.worth = product.getPrice().mul(unitsNumber);
        this.netWorth = product.getPrice().mul(unitsNumber)
                .mul(unitsNumber > NUMBER_FOR_DISCOUNT && product.isDiscount() ?
                (100 - (float) DISCOUNT_PERCENT) / 100 :
                1);
    }

    public String getLine() {
        return String.format(PurchaseTable.getFormatPurchase(),
                unitsNumber,
                product.getName(),
                product.getPrice(),
                getWorth());
    }

    public String getDiscountLine() {
        return String.format(PurchaseTable.getFormatDiscountPurchase(), getWorth() +
                "-" + (unitsNumber > NUMBER_FOR_DISCOUNT && product.isDiscount() ? ((float) DISCOUNT_PERCENT / 100) : 0 ) +
                "*" + getWorth() +
                "(" + getWorth().mul((float) DISCOUNT_PERCENT / 100) +
                ")=" + getNetWorth());
    }

    public Byn getNetWorth() {
        return netWorth;
    }

    public Byn getWorth() {
        return worth;
    }

    public Product getProduct() {
        return product;
    }

    public int getUnitsNumber() {
        return unitsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return unitsNumber == purchase.unitsNumber && Objects.equals(worth, purchase.worth) && Objects.equals(netWorth, purchase.netWorth) && Objects.equals(product, purchase.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(worth, netWorth, product, unitsNumber);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "worth=" + worth +
                ", netWorth=" + netWorth +
                ", product=" + product +
                ", unitsNumber=" + unitsNumber +
                '}';
    }
}
