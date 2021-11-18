package dao.impl;

import bean.Card;
import dao.CardDao;
import exeption.DaoException;
import exeption.WrongNumberException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static constant.Constants.*;

public class CsvCardDao implements CardDao {
    private String fileName;

    public CsvCardDao(String param) {
        fileName = param;
    }

    @Override
    public Card getCard(int number) throws DaoException {
        if (number == NO_CARD) {
            return new Card(NO_CARD,NO_CARD);
        }

        List<Card> cards = new ArrayList<>();

        try (Scanner sc = new Scanner(this.getClass().getResourceAsStream("/"+fileName))) {
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(DELIMITER_CSV);
                cards.add(new Card(Integer.parseInt(line[IND_CARD_NUMBER]), Integer.parseInt(line[IND_CARD_DISCOUNT])));
            }
            return cards.stream().filter(card -> card.getNumber() == number).findAny().get();
        } catch (NullPointerException e) {
            throw new DaoException(e);
        } catch (NumberFormatException e) {
            throw new WrongNumberException();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(NO_ELEMENT_ERROR);
        }
    }
}
