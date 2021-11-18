package dao.impl;

import bean.Byn;
import bean.Product;
import dao.ProductDao;
import exeption.DaoException;
import exeption.WrongNumberException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static constant.Constants.*;

public class CsvProductDao implements ProductDao {
    private String fileName;

    public CsvProductDao(String param) {
        fileName = param;
    }

    @Override
    public List<Product> getProducts(List<Integer> ids) throws DaoException {
        List<Product> products = new ArrayList<>();
        try (Scanner sc = new Scanner(this.getClass().getResourceAsStream("/"+fileName))) {
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(DELIMITER_CSV);
                products.add(new Product(
                        Integer.parseInt(line[IND_PRODUCT_ID]),
                        line[IND_PRODUCT_NAME],
                        new Byn(Integer.parseInt(line[IND_PRODUCT_PRICE])),
                        Boolean.parseBoolean(line[IND_PRODUCT_IS_DISCOUNT])));
            }
            return ids.stream()
                    .map(id -> products.stream()
                            .filter(product -> id.equals(product.getId()))
                            .findAny()
                            .get())
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            throw new DaoException(e);
        } catch (NumberFormatException e) {
            throw new WrongNumberException();
        }
    }
}
