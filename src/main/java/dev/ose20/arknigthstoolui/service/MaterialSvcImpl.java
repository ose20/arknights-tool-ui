package dev.ose20.arknigthstoolui.service;

import dev.ose20.arknigthstoolui.config.ApiServerConfig;
import dev.ose20.arknigthstoolui.dto.Material;
import dev.ose20.arknigthstoolui.dto.MaterialDetail;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class MaterialSvcImpl implements MaterialSvc {
    private final ApiServerConfig config;
    private final RestOperations restOperations;
    private String apiUrlPrefix;

    MaterialSvcImpl(ApiServerConfig config, RestOperations restOperations) {
        this.config = config;
        this.restOperations = restOperations;
    }

    @PostConstruct
    public void init() {
        this.apiUrlPrefix = String.format("http://%s:%s/v1/s/materials", config.host(), config.port());
        System.out.println(apiUrlPrefix);
    }

    @Override public List<Material> findAll() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.apiUrlPrefix);

        return Arrays.asList(
            Objects.requireNonNull(restOperations.getForObject(
                builder.build().toUriString(),
                Material[].class)
            )
        );
    }

    @Override public Material findById(Long id) {
        return null;
    }

    @Override public MaterialDetail findDetailById(Long id) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(String.format("%s/detail/%s", apiUrlPrefix, id));

        return Objects.requireNonNull(
            restOperations.getForObject(
                builder.build().toUriString(),
                MaterialDetail.class
            )
        );
    }
}
