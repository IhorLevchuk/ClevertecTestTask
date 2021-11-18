package factory;

import dao.CardDao;
import dao.impl.CsvCardDao;
import dao.impl.MemoryCardDao;

import static constant.Constants.NO;

public class CardFactory {
    private static CardDao cardImpl;

    private enum Sources {
        CSV{
            @Override
            CardDao getCardImpl(String param) {
                return new CsvCardDao(param);
            }
        },
        MEMORY{
            @Override
            CardDao getCardImpl(String param) {
                return new MemoryCardDao();
            }
        };
        abstract CardDao getCardImpl(String param) ;
    }

    public static void init(String param) {
        Sources kind = param != NO ? Sources.CSV : Sources.MEMORY;
        cardImpl = kind.getCardImpl(param);
    }

    public static CardDao getClassFromFactory() {
        return cardImpl;
    }
}
