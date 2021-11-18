package constant;

public class Constants {

    //General
    public final static String DATE_REG = "yyyy.MM.dd 'at' HH:mm:ss";
    public final static String HEADER = "CASH RECEIPT\n";
    public final static String NAME_SHOP = "Green\n";
    public final static String PHONE = "Tel: +375298269132\n";
    public final static String DELIMITER_CHECK = "----------------------------------------\n";
    public final static String TAXABLE_TOT = "Taxable TOT.";
    public final static String VAT_REG = "VAT %d %%";
    public final static String TOTAL = "TOTAL";

    public final static String DELIMITER_CSV = ";";

    public final static int NO_CARD = 0;
    public final static String NO = "";

    public final static String FILE_FOR_WRITING = "check.txt";

    //DAO
    public final static int IND_CARD_NUMBER = 0;
    public final static int IND_CARD_DISCOUNT = 1;

    public final static int IND_PRODUCT_ID = 0;
    public final static int IND_PRODUCT_NAME = 1;
    public final static int IND_PRODUCT_PRICE = 2;
    public final static int IND_PRODUCT_IS_DISCOUNT = 3;

    // Exception
    public final static String NO_ELEMENT_ERROR = "There is no item in the database with one of the id specified in the parameters.";
    public final static String ERROR_EXCEPTION_NON_POSITIVE_HEAD = "non positive value ";
    public final static String ERROR_FORMAT_NUMBER = "value does not satisfy the number format";

    //WebParser
    public final static String NAME_MODEL = "check";
    public final static String NAME_VIEW = "check";
    public final static String QUANTITY = "quantity";
    public final static String CARD = "card";
    public final static String CARD_FILE = "cardFile";
    public final static String PRODUCT_FILE = "productFile";
    public final static String EMAIL = "email";

    public final static String ITEM_REG = "^item(\\d*)$";
    public final static int ITEM_REG_GROUP_ID = 1;

    //ConsoleParser
    public final static String EMAIL_REG ="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public final static String CSV_REG = "^.+\\.csv$";
    public final static String PARAM_REG = "^(\\d*)-(\\d*)$";
    public final static int PARAM_REG_GROUP_ID = 1;
    public final static int PARAM_REG_GROUP_QUANTITY = 2;
    public final static String CARD_REG = "^card-(\\d*)$";
    public final static int CARD_REG_GROUP_NUMBER = 1;

    //Email
    public final static String EMAIL_NAME = "valikkrasovsky";
    public final static String EMAIL_FROM = EMAIL_NAME + "@yandex.ru";
    public final static String EMAIL_PASSWORD = "qwertyuiopqwertyuiop";

}
