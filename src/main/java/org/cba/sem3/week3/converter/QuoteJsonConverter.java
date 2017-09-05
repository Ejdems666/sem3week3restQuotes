package org.cba.sem3.week3.converter;

import com.google.gson.Gson;
import org.cba.sem3.week3.data.Quote;

import java.util.List;

/**
 * Created by adam on 05/09/2017.
 */
public class QuoteJsonConverter {
    private static final Gson gson = new Gson();

    public static String getJsonFromQuote(Quote quote) {
        return gson.toJson(quote);
    }

    public static String getJsonFromQuotes(List<Quote> quotes) {
        return gson.toJson(quotes);
    }

    public static Quote JsonToQuote(String json) {
        return gson.fromJson(json,Quote.class);
    }
}
