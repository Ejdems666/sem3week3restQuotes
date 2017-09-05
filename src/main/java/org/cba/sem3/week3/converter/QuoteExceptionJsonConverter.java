package org.cba.sem3.week3.converter;

import com.google.gson.Gson;
import org.cba.sem3.week3.exception.QuoteException;

/**
 * Created by adam on 05/09/2017.
 */
public class QuoteExceptionJsonConverter {
    private static final Gson gson = new Gson();

    public static String getJsonFromException(QuoteException exception) {
        return gson.toJson(exception);
    }
}
