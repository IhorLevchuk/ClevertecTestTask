package factory;

import dao.impl.CsvCardDao;
import dao.impl.MemoryCardDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardFactoryTest {

    @Test
    void init() {
        String param = "file.csv";
        CardFactory.init(param);
        assertTrue(CardFactory.getClassFromFactory().getClass() == CsvCardDao.class);
    }

    @Test
    void initNoFile() {
        String param = "";
        CardFactory.init(param);
        assertTrue(CardFactory.getClassFromFactory().getClass() == MemoryCardDao.class);
    }
}