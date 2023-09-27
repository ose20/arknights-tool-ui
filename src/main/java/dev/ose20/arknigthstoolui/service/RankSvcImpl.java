package dev.ose20.arknigthstoolui.service;

import dev.ose20.arknigthstoolui.config.ApiServerConfig;
import dev.ose20.arknigthstoolui.dto.Rank;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Service
public class RankSvcImpl implements RankSvc {
    private final ApiServerConfig config;
    private final RestOperations restOperations;
    private String apiUrlPrefix;

    RankSvcImpl(ApiServerConfig config, RestOperations restOperations) {
        this.config = config;
        this.restOperations = restOperations;
    }

    @PostConstruct
    public void init() {
        this.apiUrlPrefix = String.format("http://%s:%s/v1/s/ranks", config.host(), config.port());
    }

    @Override public Rank findById(Long id) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(String.format("%s/%s", apiUrlPrefix, id));

        return Objects.requireNonNull(restOperations.getForObject(builder.build().toUriString(), Rank.class));
    }
}
