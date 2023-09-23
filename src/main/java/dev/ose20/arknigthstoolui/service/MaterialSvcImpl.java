package dev.ose20.arknigthstoolui.service;

import dev.ose20.arknigthstoolui.config.ApiServerConfig;
import dev.ose20.arknigthstoolui.dto.Material;
import dev.ose20.arknigthstoolui.dto.MaterialDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.util.List;

@Service
public class MaterialSvcImpl implements MaterialSvc {
    private final ApiServerConfig config;
    private final RestOperations restOperations;

    MaterialSvcImpl(ApiServerConfig config, RestOperations restOperations) {
        this.config = config;
        this.restOperations = restOperations;
    }

    @Override public List<Material> findAll() {
        return null;
    }

    @Override public Material findById(Long id) {
        return null;
    }

    @Override public MaterialDetail findDetailById(Long id) {
        return null;
    }
}
