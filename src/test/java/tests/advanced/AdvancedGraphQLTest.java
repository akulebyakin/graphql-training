package tests.advanced;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.GqlUtils.readGql;

import client.AdvancedGraphQLClient;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import pojo.Info;
import pojo.Users;

public class AdvancedGraphQLTest {

    private static final String URL = "https://api.spacex.land/graphql/";
    private final AdvancedGraphQLClient graphQLClient = new AdvancedGraphQLClient(URL);

    @Test
    void testCanGetCompanyInfo() {
        var query = readGql("company.gql");

        graphQLClient
            .execute(query)
            .then()
            .body("data.company.ceo", equalTo("Elon Musk"));
    }

    @Test
    void testCanGetCompanyInfoAsPojo() {
        var query = readGql("company.gql");

        Info companyInfo = graphQLClient
            .execute(query)
            .then()
            .asPojo(Info.class);

        assertThat(companyInfo.getCeo(), equalTo("Elon Musk"));
    }

    @Test
    void testCanGetUsersWithVariablesAsList() {
        int limit = 1;
        Map<String, Object> variables = Map.of("limit", limit);

        List<Users> users = graphQLClient
            .executeGqlFile("users.gql", variables)
            .then()
            .asList(Users.class);

        assertThat(users.size(), equalTo(limit));
    }
}
