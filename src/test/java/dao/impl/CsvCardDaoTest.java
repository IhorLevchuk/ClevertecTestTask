package dao.impl;

import bean.Card;
import exeption.DaoException;
import exeption.WrongNumberException;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CsvCardDaoTest {

    @Test
    void getCard() throws DaoException {
        CsvCardDao cardDao = new CsvCardDao("cardsTest.csv");
        int number = 722;
        assertEquals(new Card(number, 10), cardDao.getCard(number));
    }

    @Test
    void getCardNotNumber() throws DaoException {
        CsvCardDao cardDao = new CsvCardDao("cardsTest.csv");
        int number = 0;
        assertEquals(new Card(number, 0), cardDao.getCard(number));
    }

    @Test
    void getCardDaoException() {
        CsvCardDao cardDao = new CsvCardDao("qwe.csv");
        int number = 452;
        Exception exception = assertThrows(DaoException.class,() -> cardDao.getCard(number));
        String expectedMessage = "exeption.DaoException";
        String actualMessage = exception.toString();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getCardWrongNumberException() {
        CsvCardDao cardDao = new CsvCardDao("cardsTest1.csv");
        int number = 452;
        Exception exception = assertThrows(WrongNumberException.class,() -> cardDao.getCard(number));
        String expectedMessage = "value does not satisfy the number format";
        String actualMessage = exception.toString();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getCardNoSuchElementException() {
        CsvCardDao cardDao = new CsvCardDao("cardsTest.csv");
        int number = 111;
        Exception exception = assertThrows(NoSuchElementException.class,() -> cardDao.getCard(number));
        String expectedMessage = "There is no item in the database with one of the id specified in the parameters.";
        String actualMessage = exception.toString();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}