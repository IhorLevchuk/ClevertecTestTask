package parser.impl;

import bean.InputParameters;
import parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constant.Constants.*;

public class ConsoleParser implements Parser {
    private String[] args;

    public ConsoleParser(String[] args) {
        this.args = args;
    }

    public InputParameters pars() {
        InputParameters input = new InputParameters();

        Pattern patternParam = Pattern.compile(PARAM_REG);
        Pattern patternCard = Pattern.compile(CARD_REG);
        Pattern patternEmail = Pattern.compile(EMAIL_REG);
        for (String arg: args) {
            Matcher matcherParam = patternParam.matcher(arg);
            if (matcherParam.find()) {
                input.addParam(Integer.parseInt(matcherParam.group(PARAM_REG_GROUP_ID)),
                        Integer.parseInt(matcherParam.group(PARAM_REG_GROUP_QUANTITY)));
            }

            Matcher matcherCard = patternCard.matcher(arg);
            if (matcherCard.find()) {
                input.setCardNumber(Integer.parseInt(matcherCard.group(CARD_REG_GROUP_NUMBER)));
            }

            Matcher matcherEmail = patternEmail.matcher(arg);
            if (matcherEmail.find()) {
                input.setEmail(matcherEmail.group(0));
            }
        }
        if (input.getCardNumber() == null) {
            input.setCardNumber(NO_CARD);
        }
        if (input.getEmail() == null) {
            input.setEmail(NO);
        }
        input.setCardFile(Pattern.matches(CSV_REG,args[args.length-1]) ? args[args.length-1] : NO);
        input.setProductFile(Pattern.matches(CSV_REG,args[args.length-2]) ? args[args.length-2] : NO);
        return input;
    }
}
