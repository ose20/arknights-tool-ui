package dev.ose20.arknigthstoolui.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;


@Configuration
@EnableConfigurationProperties(ApiServerConfig.class)
public class RestConfig {
    private final ApiServerConfig serverConfig;

    public RestConfig(ApiServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }

    @Bean
    public RestOperations restTemplate(RestTemplateBuilder builder) {
        return builder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
    }
}
