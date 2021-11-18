package bean;

import enumeration.PurchaseTable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static constant.Constants.*;

public class Check {
    private final String header = HEADER;
    private final String nameShop = NAME_SHOP;
    private final String phone = PHONE;
    private final List<Purchase> purchases;
    private final Card card;

    public Check(Map<Integer, Integer> params, List<Product> products, Card card) {
        this.purchases = products.stream()
                .map(product -> new Purchase(product, params.get(product.getId())))
                .collect(Collectors.toList());
        this.card = card;
    }

    public Check(List<Purchase> purchases, Card card) {
        this.purchases = purchases;
        this.card = card;
    }

    public String getStringCheck() {
        StringBuilder check = new StringBuilder();
        check
                .append(header)
                .append(nameShop)
                .append(phone)
                .append(new SimpleDateFormat(DATE_REG).format(new Date()))
                .append("\n")
                .append(PurchaseTable.getTitleLine())
                .append(DELIMITER_CHECK);
        purchases.forEach(purchase -> check.append(purchase.getLine()).append(purchase.getDiscountLine()));
        check
                .append(DELIMITER_CHECK)
                .append(card.getDiscount() == NO_CARD ? "" : String.format(PurchaseTable.getFormatResults(),
                        TAXABLE_TOT,
                        getTableTot()))
                .append(card.getDiscount() == NO_CARD ? "" : String.format(PurchaseTable.getFormatResults(),
                        String.format(VAT_REG, card.getDiscount()),
                        getVat()))
                .append(String.format(PurchaseTable.getFormatResults(), TOTAL, getTotal()));
        return check.toString();
    }

    public String getHeader() {
        return header;
    }

    public String getNameShop() {
        return nameShop;
    }

    public String getPhone() {
        return phone;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public Byn getTableTot() {
        return purchases.stream().map(Purchase::getNetWorth).reduce(Byn::add).get();
    }

    public Byn getVat() {
        return getTableTot().mul((float) card.getDiscount() / 100);
    }

    public Byn getTotal() {
        return getTableTot().sub(getVat());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Objects.equals(header, check.header) && Objects.equals(nameShop, check.nameShop) && Objects.equals(phone, check.phone) && Objects.equals(purchases, check.purchases) && Objects.equals(card, check.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, nameShop, phone, purchases, card);
    }

    @Override
    public String toString() {
        return "Check{" +
                "header='" + header + '\'' +
                ", nameShop='" + nameShop + '\'' +
                ", phone='" + phone + '\'' +
                ", purchases=" + purchases +
                ", card=" + card +
                '}';
    }
}
