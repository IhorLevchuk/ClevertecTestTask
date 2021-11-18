package controller;

import bean.InputParameters;
import bean.Check;
import dao.CardDao;
import dao.ProductDao;
import exeption.DaoException;
import exeption.OutputException;
import factory.CardFactory;
import factory.ProductFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import output.CheckOutput;
import output.impl.EmailCheckOutput;
import parser.Parser;
import parser.impl.WebParser;

import java.util.Map;

import static constant.Constants.*;

@Controller
@RequestMapping("/check")
public class CheckController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCheck(@RequestParam Map<String, String> reqParam) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Parser parser = new WebParser(reqParam);

            InputParameters inputParameters = parser.pars();
            ProductFactory.init(inputParameters.getProductFile());
            ProductDao productDao = ProductFactory.getClassFromFactory();
            CardFactory.init(inputParameters.getCardFile());
            CardDao cardDao = CardFactory.getClassFromFactory();
            Check check = new Check(
                    inputParameters.getParams(),
                    productDao.getProducts(inputParameters.getIdProducts()),
                    cardDao.getCard(inputParameters.getCardNumber()));

            CheckOutput emailCheckOutput = new EmailCheckOutput(inputParameters.getEmail());
            emailCheckOutput.output(check.getStringCheck());

            modelAndView.addObject(NAME_MODEL,check);
            modelAndView.setViewName(NAME_VIEW);
            return modelAndView;
        } catch (DaoException | OutputException e) {
            throw new RuntimeException(e);
        }
    }
}
