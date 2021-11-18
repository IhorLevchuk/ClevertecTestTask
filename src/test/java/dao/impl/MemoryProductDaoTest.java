package dao.impl;

import bean.Byn;
import bean.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryProductDaoTest {

    @Test
    void getProducts() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<Product> expected = new ArrayList<>();
        expected.add(new Product(1, "Milk", new Byn(1,70), true));
        expected.add(new Product(2, "Beer", new Byn(2,10), false));
        assertEquals(expected, new MemoryProductDao().getProducts(ids));
    }
}