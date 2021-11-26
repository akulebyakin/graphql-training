package tests.client;

import static org.hamcrest.Matchers.equalTo;
import static utils.GqlUtils.gql;

import client.GraphQLClient;
import org.junit.jupiter.api.Test;

public class FirstGraphQLTestWithClient {

    private static final String URL = "https://api.spacex.land/graphql/";
    private final GraphQLClient graphQLClient = new GraphQLClient(URL);

    @Test
    void testCanGetCeo() {
        var query = "{ \"query\": \"{ company { employees name ceo coo }}\" }";

        graphQLClient.execute(query)
                     .then()
                     .body("data.company.ceo", equalTo("Elon Musk"));
    }

    @Test
    void testCanGetCeoWithQuery() {
//        var query = new GraphQLQuery("{ company { employees name ceo coo } }");
        var query = gql("{ company { employees name ceo coo } }");

        graphQLClient.execute(query)
                     .then()
                     .body("data.company.ceo", equalTo("Elon Musk"));
    }

}
