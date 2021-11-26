package utils;

import static org.aeonbits.owner.Config.Sources;

import org.aeonbits.owner.Config;

@Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

//    @Key("env")
    @DefaultValue("dev")
    String env();

    @Key("${env}.graphql.url")
    String graphqlUrl();
}
