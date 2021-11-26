package client;

import static io.restassured.RestAssured.given;
import static utils.GqlUtils.readGql;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import response.GraphQLResponse;

@Log4j2
public class AdvancedGraphQLClient {

    private final String url;

    private final RequestSpecification requestSpecification;

    public AdvancedGraphQLClient(String url) {
        this.url = url;
        requestSpecification = given()
            .contentType(ContentType.JSON)
            .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public GraphQLResponse execute(String query) {
        return new GraphQLResponse(requestSpecification
            .body(query)
            .post(url));
    }

    public GraphQLResponse execute(GraphQLQuery query) {
        log.info("Execute query: \"{}\"", query.toString());
        return new GraphQLResponse(requestSpecification
            .body(query)
            .post(url));
    }

    public GraphQLResponse executeGqlFile(String fileName) {
        var query = readGql(fileName);
        return execute(query);
    }

    public GraphQLResponse executeGqlFile(String fileName, Object variables) {
        var query = readGql(fileName, variables);
        return execute(query);
    }
}
