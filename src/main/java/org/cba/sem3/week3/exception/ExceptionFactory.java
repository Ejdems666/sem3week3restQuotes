package org.cba.sem3.week3.exception;

import com.google.gson.JsonObject;

/**
 * Created by adam on 08/09/2017.
 */
public class ExceptionFactory {
    public static QuoteNotFound createNotFound(int id) {
        JsonObject message = new JsonObject();
        message.addProperty("error","Quote with id "+id+" was not found!");
        return new QuoteNotFound(message.toString());
    }
}
