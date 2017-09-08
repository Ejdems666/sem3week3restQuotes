package org.cba.sem3.week3.resources;

import com.google.gson.JsonObject;
import org.cba.sem3.week3.converter.QuoteJsonConverter;
import org.cba.sem3.week3.data.Quote;
import org.cba.sem3.week3.data.QuotesRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by adam on 05/09/2017.
 */
@Path("quote")
public class QuoteResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllQuotes() {
        List<Quote> quotes = QuotesRepository.getAllQuotes();
        return QuoteJsonConverter.getJsonFromQuotes(quotes);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuote(@PathParam("id") int id) {
        Quote quote = QuotesRepository.getQuote(id);
        return QuoteJsonConverter.getJsonFromQuote(quote);
    }

    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomQuote() {
        Quote quote = QuotesRepository.getRandomQuote();
        return QuoteJsonConverter.getJsonFromQuote(quote);

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createQuote(String json) {
        Quote quote = QuoteJsonConverter.JsonToQuote(json);
        QuotesRepository.addQuote(quote);
        return QuoteJsonConverter.getJsonFromQuote(quote);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateQuote(String json, @PathParam("id") int id) {
        Quote quote = QuoteJsonConverter.JsonToQuote(json);
        Quote updatedQuote = QuotesRepository.updateQuote(id, quote);
        return QuoteJsonConverter.getJsonFromQuote(updatedQuote);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteQuote(@PathParam("id") int id) {
        QuotesRepository.deleteQuote(id);
        JsonObject successMessage = new JsonObject();
        successMessage.addProperty("success", "Quote with id " + id + " was deleted!");
        return successMessage.toString();
    }
}
