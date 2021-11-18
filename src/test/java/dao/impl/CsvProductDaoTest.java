package dao.impl;

import bean.*;
import exeption.DaoException;
import exeption.WrongNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvProductDaoTest {
    List<Integer> ids;

    @BeforeEach
    void setUp() {
        ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
    }

    @Test
    void getProducts() throws DaoException {
        CsvProductDao productDao = new CsvProductDao("productsTest.csv");
        List<Product> expected = new ArrayList<>();
        expected.add(new Product(1, "Milk", new Byn(1,70), true));
        expected.add(new Product(2, "Beer", new Byn(2,10), false));
        assertEquals(expected, productDao.getProducts(ids));
    }

    @Test
    void getProductsDaoException() {
        CsvProductDao productDao = new CsvProductDao("qwe.csv");
        List<Integer> idsEmpty = new ArrayList<>();
        Exception exception = assertThrows(DaoException.class,() -> productDao.getProducts(idsEmpty));
        String expectedMessage = "exeption.DaoException";
        String actualMessage = exception.toString();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getProductsWrongNumberException() {
        CsvProductDao productDao = new CsvProductDao("productsTest1.csv");
        List<Integer> idsEmpty = new ArrayList<>();
        Exception exception = assertThrows(WrongNumberException.class,() -> productDao.getProducts(idsEmpty));
        String expectedMessage = "value does not satisfy the number format";
        String actualMessage = exception.toString();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}