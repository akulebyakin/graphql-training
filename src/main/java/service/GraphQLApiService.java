package service;

import static utils.GqlUtils.readGql;

import client.AdvancedGraphQLClient;
import java.util.List;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import pojo.Info;
import pojo.Users;

@Log4j2
public class GraphQLApiService {

    private final AdvancedGraphQLClient advancedGraphQLClient;

    public GraphQLApiService(AdvancedGraphQLClient advancedGraphQLClient) {
        this.advancedGraphQLClient = advancedGraphQLClient;
    }

    public Info getCompanyInfo() {
        var query = readGql("company.gql");
        log.info("About to get company info");

        return advancedGraphQLClient
            .execute(query)
            .then()
            .asPojo(Info.class);
    }

    public List<Users> getUsers(Map<?, ?> variables) {
        return advancedGraphQLClient
            .executeGqlFile("users.gql", variables)
            .then()
            .asList(Users.class);
    }
}
