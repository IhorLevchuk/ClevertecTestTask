package parser.impl;

import bean.InputParameters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleParserTest {

    @Test
    void pars() {
        String[] args = {"3-2", "2-5", "1-6", "card-452", "ihor.levchuk@yandex.by", "products.csv", "cards.csv"};
        InputParameters actual = new ConsoleParser(args).pars();
        InputParameters expected = new InputParameters();
        expected.addParam(3,2);
        expected.addParam(2,5);
        expected.addParam(1,6);
        expected.setCardNumber(452);
        expected.setCardFile("cards.csv");
        expected.setProductFile("products.csv");
        expected.setEmail("ihor.levchuk@yandex.by");
        assertEquals(expected, actual);
    }

}