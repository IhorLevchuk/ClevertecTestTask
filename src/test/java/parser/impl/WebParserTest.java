package parser.impl;

import bean.InputParameters;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WebParserTest {

    @Test
    void pars() {
        Map<String, String> reqParam = new HashMap<>();
        reqParam.put("item1","3");
        reqParam.put("quantity1","2");
        reqParam.put("item2","2");
        reqParam.put("quantity2","5");
        reqParam.put("item3","1");
        reqParam.put("quantity3","6");
        reqParam.put("card","452");
        reqParam.put("productFile","products.csv");
        reqParam.put("cardFile","cards.csv");
        reqParam.put("email","ihor.levchuk@yandex.by");
        InputParameters actual = new WebParser(reqParam).pars();
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