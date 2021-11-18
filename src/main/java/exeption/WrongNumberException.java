package exeption;

import static constant.Constants.ERROR_FORMAT_NUMBER;

public class WrongNumberException extends IllegalArgumentException {
    public WrongNumberException() {
        super(ERROR_FORMAT_NUMBER);
    }
}
