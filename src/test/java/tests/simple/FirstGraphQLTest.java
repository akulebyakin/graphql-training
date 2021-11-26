package tests.simple;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class FirstGraphQLTest {

    private static final String URL = "https://api.spacex.land/graphql/";

    @Test
    void testCanGetCeo() {
        var query = "{ \"query\": \"{ company { employees name ceo coo }}\" }";

        RestAssured
            .given()
            .contentType(ContentType.JSON)
            // Позволяет видеть запросы и ответы -> .filters
            .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
            .body(query)
            .when()
            .post(URL)
            .then()
            .assertThat()
            .body("data.company.ceo", equalTo("Elon Musk"));
    }
}
