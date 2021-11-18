package enumeration;

import java.util.Formatter;

public enum PurchaseTable {
    QTY(5),
    DESCRIPTION( 10),
    PRICE( 12),
    TOTAL( 12);

    int columnWidth;

    PurchaseTable(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    public static String getFormatTitle() {
        return "%-" + QTY.columnWidth + "s%-" + DESCRIPTION.columnWidth + "s%" + PRICE.columnWidth + "s%" + TOTAL.columnWidth + "s\n";
    }

    public static String getFormatPurchase() {
        return "%-" + QTY.columnWidth + "d%-" + DESCRIPTION.columnWidth + "s%" + PRICE.columnWidth + "s%" + TOTAL.columnWidth + "s\n";
    }

    public static String getFormatDiscountPurchase() {
        return "%" + (QTY.columnWidth + DESCRIPTION.columnWidth + PRICE.columnWidth + TOTAL.columnWidth) + "s\n";
    }

    public static String getFormatResults() {
        return "%-" + (QTY.columnWidth + DESCRIPTION.columnWidth) + "s%" + (PRICE.columnWidth + TOTAL.columnWidth) + "s\n";
    }

    public static String getTitleLine() {
        Formatter formatter = new Formatter();
        return formatter.format(PurchaseTable.getFormatTitle(), QTY, DESCRIPTION, PRICE, TOTAL).toString();
    }
}
