package exeption;

import static constant.Constants.ERROR_EXCEPTION_NON_POSITIVE_HEAD;

public class NonPositiveArgumentException extends IllegalArgumentException {
    public NonPositiveArgumentException(int nonPositiveValue) {
        super(ERROR_EXCEPTION_NON_POSITIVE_HEAD + nonPositiveValue);
    }
}
