package dev.ose20.arknigthstoolui.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("api.server")
public record ApiServerConfig(String host, int port) {
}
