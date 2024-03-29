package com.learning.springboot.error;

public class ExpenseNotFoundException extends Exception {

    public ExpenseNotFoundException() {
        super();
    }

    public ExpenseNotFoundException(String message) {
        super(message);
    }

    public ExpenseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpenseNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ExpenseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
