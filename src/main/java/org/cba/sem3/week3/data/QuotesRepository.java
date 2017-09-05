package org.cba.sem3.week3.data;

import org.cba.sem3.week3.exception.QuoteNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by adam on 05/09/2017.
 */
public class QuotesRepository {
    private static List<Quote> quotes;

    static {
        quotes = new ArrayList<>();
        quotes.add(new Quote(1, "Friends are kisses blown to us by angels"));
        quotes.add(new Quote(2, "Do not take life too seriously. You will never get out of it alive"));
        quotes.add(new Quote(3, "Behind every great man, is a woman rolling her eyes"));
    }

    public static Quote getQuote(int id) {
        for (Quote quote : quotes) {
            if (quote.getId() == id) {
                return quote;
            }
        }
//        throw new QuoteNotFound();
        return null;
    }

    public static List<Quote> getAllQuotes() {
        return quotes;
    }

    public static void addQuote(Quote quote) {
        quote.setId(quotes.size());
        quotes.add(quote);
    }

    public static void deleteQuote(int id) throws QuoteNotFound {
        for (Quote quote : quotes) {
            if (quote.getId() == id) {
                quotes.remove(quote);
                return;
            }
        }
        throw new QuoteNotFound(id);
    }

    public static Quote updateQuote(int id, Quote updatedQuote) throws QuoteNotFound {
        for (int i = 0; i < quotes.size(); i++) {
            if (quotes.get(i).getId() == id) {
                quotes.get(i).setQuote(updatedQuote.getQuote());
                return quotes.get(i);
            }
        }
        throw new QuoteNotFound(id);
    }

    public static Quote getRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }
}
