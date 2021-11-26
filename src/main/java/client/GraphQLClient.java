package client;

import static io.restassured.RestAssured.given;
import static utils.GqlUtils.readGql;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GraphQLClient {

    private final String url;

    private final RequestSpecification requestSpecification;

    public GraphQLClient(String url) {
        this.url = url;
        requestSpecification = given()
            .contentType(ContentType.JSON)
            .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public Response execute(String query) {
        return requestSpecification
            .body(query)
            .post(url);
    }

    public Response execute(GraphQLQuery query) {
        return requestSpecification
            .body(query)
            .post(url);
    }

    public Response executeGqlFile(String fileName) {
        var query = readGql(fileName);
        return execute(query);
    }

    public Response executeGqlFile(String fileName, Object variables) {
        var query = readGql(fileName, variables);
        return execute(query);
    }
}
