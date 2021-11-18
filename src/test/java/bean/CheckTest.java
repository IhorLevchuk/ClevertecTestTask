package bean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckTest {
    Check check;

    @BeforeEach
    void setUp() {
        List<Purchase> purchases = new ArrayList<>();
        Purchase purchase1 = new Purchase(new Product(1, "Milk", new Byn(1,70), true), 4);
        Purchase purchase2 = new Purchase(new Product(2, "Sausage", new Byn(5,60), true), 6);
        Purchase purchase3 = new Purchase(new Product(4, "Sausage", new Byn(3,52), false), 2);
        purchases.add(purchase1);
        purchases.add(purchase2);
        purchases.add(purchase3);
        check = new Check(purchases, new Card(0,12));
    }

    @Test
    void getStringCheck() {
        assertTrue(check.getStringCheck().contains(
                "4    Milk              1.70        6.80\n" +
                "               6.80-0.0*6.80(0.68)=6.80\n" +
                "6    Sausage           5.60       33.60\n" +
                "            33.60-0.1*33.60(3.36)=30.23\n" +
                "2    Sausage           3.52        7.04\n" +
                "               7.04-0.0*7.04(0.70)=7.04\n" +
                "----------------------------------------\n" +
                "Taxable TOT.                      44.07\n" +
                "VAT 12 %                           5.28\n" +
                "TOTAL                             38.79"));
    }

    @Test
    void getTableTot() {
        assertEquals(new Byn(44,7), check.getTableTot());
    }

    @Test
    void getVat() {
        assertEquals(new Byn(5,28), check.getVat());
    }

    @Test
    void getTotal() {
        assertEquals(new Byn(38,79), check.getTotal());
    }

}