package dao;

import bean.Product;
import exeption.DaoException;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(List<Integer> ids) throws DaoException;
}
