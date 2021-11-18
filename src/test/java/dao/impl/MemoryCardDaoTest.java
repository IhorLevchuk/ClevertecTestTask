package dao.impl;

import bean.Card;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MemoryCardDaoTest {

    @Test
    void getCard() {
        int number = 722;
        assertEquals(new Card(number, 10), new MemoryCardDao().getCard(number));
    }

    @Test
    void getCardNotNumber() {
        int number = 0;
        assertEquals(new Card(number, 0), new MemoryCardDao().getCard(number));
    }

    @Test
    void getCardNoSuchElementException() {
        int number = 111;
        Exception exception = assertThrows(NoSuchElementException.class,() -> new MemoryCardDao().getCard(number));
        String expectedMessage = "There is no item in the database with one of the id specified in the parameters.";
        String actualMessage = exception.toString();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}