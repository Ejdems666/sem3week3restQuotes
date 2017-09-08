package rest;

import org.cba.sem3.week3.data.Quote;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by adam on 08/09/2017.
 */
public class QuoteRestTest extends FunctionalTest{
    @Test
    public void specificQuote() {
        given().when().get("/quote/1")
                .then().body("id",equalTo(1));
    }

    @Test
    public void invalidQuote() {
        given().when().get("/quote/999")
                .then().statusCode(404);
    }

    @Test
    public void randomQuote() {
        given().when().get("/quote/random")
                .then().statusCode(200);
    }

    @Test
    public void allQuotes() {
        given().when().get("/quote")
                .then().statusCode(200);
    }

    @Test
    public void createQuote() {
        Quote quote = new Quote("some quote");
        given().contentType("application/json")
                .body(quote)
                .when().post("/quote").then()
                .body("quote",equalTo(quote.getQuote()))
                .statusCode(200);
    }

    @Test
    public void updateQuote() {
        int id = 1;
        Quote quote = new Quote(id,"new quote text");
        given().contentType("application/json")
                .body(quote)
                .pathParam("id", id)
                .when().put("/quote/{id}").then()
                .body("quote",equalTo(quote.getQuote()))
                .statusCode(200);
    }

    @Test
    public void deleteQuote() {
        int id = 3;
        Quote quote = new Quote(id,"new quote text");
        given().contentType("application/json")
                .body(quote)
                .pathParam("id", id)
                .when().delete("/quote/{id}").then()
                .body(containsString("deleted"))
                .statusCode(200);
    }
}
