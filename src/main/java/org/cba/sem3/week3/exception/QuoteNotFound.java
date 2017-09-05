package org.cba.sem3.week3.exception;

/**
 * Created by adam on 05/09/2017.
 */
public class QuoteNotFound  extends Exception implements QuoteException {
    private int code = 404;

    public QuoteNotFound(int id) {
        super("Quote with id "+id+" was not found!");
    }

    @Override
    public int getCode() {
        return code;
    }
}
