package dao;

import bean.Card;
import exeption.DaoException;

public interface CardDao {
    Card getCard(int number) throws DaoException;
}
