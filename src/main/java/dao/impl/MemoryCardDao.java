package dao.impl;

import bean.Card;
import dao.CardDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static constant.Constants.NO_CARD;
import static constant.Constants.NO_ELEMENT_ERROR;

public class MemoryCardDao implements CardDao {
    @Override
    public Card getCard(int number) {
        if (number == NO_CARD) {
            return new Card(NO_CARD,NO_CARD);
        }
        try {
            List<Card> cards = new ArrayList<>(Arrays.asList(
                    new Card(452, 17),
                    new Card(722, 10),
                    new Card(182, 5)));
            return cards.stream().filter(card -> card.getNumber() == number).findAny().get();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(NO_ELEMENT_ERROR);
        }
    }
}
