package utils;

import client.GraphQLQuery;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Objects;

public class GqlUtils {

    private static final String QUERIES_PATH = "queries";

    public static GraphQLQuery gql(String queryString) {
        // Тут могут быть логи
        return new GraphQLQuery(queryString);
    }

    public static GraphQLQuery gql(String queryString, Object variables) {
        return new GraphQLQuery(queryString, variables);
    }

    private static String readFile(String fileName) {
        fileName = QUERIES_PATH + "/" + fileName;
        URL url = GqlUtils.class
            .getClassLoader()
            .getResource(fileName);

        File file = new File(Objects.requireNonNull(url).getFile());
        try {
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read " + fileName);
        }
    }

    public static GraphQLQuery readGql(String fileName) {
        return gql(readFile(fileName));
    }

    public static GraphQLQuery readGql(String fileName, Object variables) {
        return gql(readFile(fileName), variables);
    }
}
