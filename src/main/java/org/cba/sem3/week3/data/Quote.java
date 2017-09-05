package org.cba.sem3.week3.data;

/**
 * Created by adam on 05/09/2017.
 */
public class Quote {
    private int id;
    private String quote;

    public Quote(int id, String quote) {
        this.id = id;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
