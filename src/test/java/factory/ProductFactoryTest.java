package factory;

import dao.impl.CsvProductDao;
import dao.impl.MemoryProductDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    @Test
    void init() {
        String param = "file.csv";
        ProductFactory.init(param);
        assertTrue(ProductFactory.getClassFromFactory().getClass() == CsvProductDao.class);
    }

    @Test
    void initNoFile() {
        String param = "";
        ProductFactory.init(param);
        assertTrue(ProductFactory.getClassFromFactory().getClass() == MemoryProductDao.class);
    }
}