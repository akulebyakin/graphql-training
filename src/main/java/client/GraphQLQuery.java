package client;

import lombok.ToString;

@ToString
public class GraphQLQuery {

    private final String query;
    private Object variables;

    public GraphQLQuery(String query) {
        this.query = query;
    }

    public GraphQLQuery(String query, Object variables) {
        this.query = query;
        this.variables = variables;
    }

    public String getQuery() {
        return query;
    }

    public Object getVariables() {
        return variables;
    }

    public void setVariables(Object variables) {
        this.variables = variables;
    }
}
