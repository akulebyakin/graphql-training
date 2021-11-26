package tests.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import client.AdvancedGraphQLClient;
import java.util.List;
import java.util.Map;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pojo.Info;
import pojo.Users;
import service.GraphQLApiService;
import utils.ProjectConfig;

public class AdvancedGraphQLServicesTest {

    private final Map<String, String> env = Map.of("env", "prod");
    private final ProjectConfig config = ConfigFactory.create(ProjectConfig.class, env);
    private final GraphQLApiService api = new GraphQLApiService(new AdvancedGraphQLClient(config.graphqlUrl()));

    @Test
    void testCanGetCompanyInfo() {
        String url = config.graphqlUrl();
        String env = config.env();
        Info companyInfo = api.getCompanyInfo();
        assertThat(companyInfo.getCeo(), equalTo("Elon Musk"));
    }

    @Test
    void testCanGetCompanyInfoAsPojo() {
        Info companyInfo = api.getCompanyInfo();
        assertThat(companyInfo.getCeo(), equalTo("Elon Musk"));
    }

    @Test
    void testCanGetUsersWithVariablesAsList() {
        int limit = 1;
        Map<String, Object> variables = Map.of("limit", limit);

        List<Users> users = api.getUsers(variables);

        assertThat(users.size(), equalTo(limit));
    }
}
