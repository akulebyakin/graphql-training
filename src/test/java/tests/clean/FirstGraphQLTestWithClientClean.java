package tests.clean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static utils.GqlUtils.readGql;

import client.GraphQLClient;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import pojo.Users;

public class FirstGraphQLTestWithClientClean {

    private static final String URL = "https://api.spacex.land/graphql/";
    private final GraphQLClient graphQLClient = new GraphQLClient(URL);

    @Test
    void testCanGetUsersWithQueryFromFile() {
        var query = readGql("users.gql");

        List<Object> users = graphQLClient
            .execute(query)
            .then()
            .extract().jsonPath().getList("data.users");
        assertThat(users.size(), equalTo(57));
    }

    @Test
    void testCanGetUsersWithQueryFromFileExecuteGql() {
        List<Users> users = graphQLClient
            .executeGqlFile("users.gql")
            .then()
            .extract().jsonPath().getList("data.users", Users.class);

        assertThat(users.size(), equalTo(57));
    }

    @Test
    void testCanGetUsersWithQueryFromFileWithVariables() {
        int limit = 1;
        Map<String, Object> variables = Map.of("limit", limit);

        List<Users> users = graphQLClient
            .executeGqlFile("users.gql", variables)
            .then()
            .extract().jsonPath().getList("data.users", Users.class);

        assertThat(users.size(), equalTo(limit));
    }

    @Test
    void testCanGetUserByNameLike() {
        String userLike = "falcon%";
        Map<?, ?> variables = Map.of("where", Map.of("name", Map.of("_like", userLike)));

        List<Object> users = graphQLClient
            .executeGqlFile("users_by_condition.gql", variables)
            .then()
            .extract().jsonPath().getList("data.users");

        assertThat(users, not(empty()));
    }
}
