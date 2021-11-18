import bean.InputParameters;
import bean.Check;
import dao.CardDao;
import dao.ProductDao;
import exeption.DaoException;
import exeption.OutputException;
import factory.CardFactory;
import factory.ProductFactory;
import output.CheckOutput;
import output.impl.ConsoleCheckOutput;
import output.impl.EmailCheckOutput;
import output.impl.FileCheckOutput;
import parser.Parser;
import parser.impl.ConsoleParser;

import static constant.Constants.FILE_FOR_WRITING;

public class Runner {
    public static void main(String[] args) {
        try {
            Parser parser = new ConsoleParser(args);

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

            CheckOutput consoleCheckOutput = new ConsoleCheckOutput();
            consoleCheckOutput.output(check.getStringCheck());

            CheckOutput fileCheckOutput = new FileCheckOutput(FILE_FOR_WRITING);
            fileCheckOutput.output(check.getStringCheck());
        } catch (DaoException | OutputException e) {
            System.out.println(e.getMessage());
        }
    }
}
