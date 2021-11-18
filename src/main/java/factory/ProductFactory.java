package factory;

import dao.ProductDao;
import dao.impl.CsvProductDao;
import dao.impl.MemoryProductDao;

import static constant.Constants.NO;


public class ProductFactory {
    private static ProductDao cardImpl;

    private enum Sources {
        CSV{
            @Override
            ProductDao getCardImpl(String param) {
                return new CsvProductDao(param);
            }
        },
        MEMORY{
            @Override
            ProductDao getCardImpl(String param) {
                return new MemoryProductDao();
            }
        };
        abstract ProductDao getCardImpl(String param) ;
    }

    public static void init(String param) {
        Sources kind = param != NO ? Sources.CSV : Sources.MEMORY;
        cardImpl = kind.getCardImpl(param);
    }

    public static ProductDao getClassFromFactory() {
        return cardImpl;
    }
}
