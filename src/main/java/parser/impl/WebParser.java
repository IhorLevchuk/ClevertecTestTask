package parser.impl;

import bean.InputParameters;
import parser.Parser;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constant.Constants.*;

public class WebParser implements Parser {
    private Map<String, String> reqParam;

    public WebParser(Map<String, String> reqParam) {
        this.reqParam = reqParam;
    }

    public InputParameters pars() {
        InputParameters input = new InputParameters();

        Pattern patternItemId = Pattern.compile(ITEM_REG);

        for (String key: reqParam.keySet()) {
            Matcher matcherParam = patternItemId.matcher(key);
            String quantity;
            if (matcherParam.find() && (quantity = reqParam.get(QUANTITY + matcherParam.group(ITEM_REG_GROUP_ID))) != null) {
                input.addParam(
                        Integer.parseInt(reqParam.get(key)),
                        Integer.parseInt(quantity));
            }
        }

        input.setCardNumber(reqParam.get(CARD) == null ? NO_CARD : Integer.parseInt(reqParam.get(CARD)));
        input.setEmail(reqParam.get(EMAIL) == null ? NO : reqParam.get(EMAIL));
        input.setCardFile(reqParam.get(CARD_FILE) == null ? NO : reqParam.get(CARD_FILE));
        input.setProductFile(reqParam.get(PRODUCT_FILE) == null ? NO : reqParam.get(PRODUCT_FILE));

        return input;
    }
}
