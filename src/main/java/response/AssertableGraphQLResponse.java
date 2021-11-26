package response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.restassured.response.Response;
import java.util.List;
import org.hamcrest.Matcher;

public class AssertableGraphQLResponse {
    private final Response response;

    public AssertableGraphQLResponse(Response response) {
        this.response = response;
    }

    public AssertableGraphQLResponse body(String jsonPath, Matcher<?> matcher) {
        response
            .then()
            .body(jsonPath, matcher);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        T object =  response
            .then()
            .extract()
            .jsonPath()
            .getObject(getJsonPath(tClass), tClass);

        if (object == null) {
            String errorMessage =
                String.format("Cannot deserialize pojo for class \"%s\" from response", tClass.getSimpleName());
            throw new RuntimeException(errorMessage);
        }

        return object;
    }

    private String getJsonPath(Class<?> tClass) {
        JsonRootName rootName = tClass.getAnnotation(JsonRootName.class);
        String name = "data";
        if (rootName != null) {
            name += "." + rootName.value();
        } else {
            name += "." + tClass.getSimpleName().toLowerCase();
        }
        return name;
    }

    public <T> List<T> asList(Class<T> tClass) {
        return response
            .then()
            .extract().jsonPath().getList(getJsonPath(tClass), tClass);
    }
}
