package dao.impl;

import bean.Byn;
import bean.Product;
import dao.ProductDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static constant.Constants.NO_ELEMENT_ERROR;

public class MemoryProductDao implements ProductDao {
    @Override
    public List<Product> getProducts(List<Integer> ids) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(1, "Milk", new Byn(1, 70), true),
                new Product(2, "Beer", new Byn(2, 10), false),
                new Product(3, "Sausage", new Byn(5, 60), false),
                new Product(4, "Fish", new Byn(10, 99), true)));
        return ids.stream()
                .map(id -> products.stream()
                        .filter(product -> id.equals(product.getId()))
                        .findAny()
                        .get())
                .collect(Collectors.toList());
    }
}
