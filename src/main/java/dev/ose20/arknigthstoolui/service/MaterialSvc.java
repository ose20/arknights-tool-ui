package dev.ose20.arknigthstoolui.service;

import dev.ose20.arknigthstoolui.dto.Material;
import dev.ose20.arknigthstoolui.dto.MaterialDetail;

import java.util.List;

public interface MaterialSvc {
    List<Material> findAll();
    Material findById(Long id);
    MaterialDetail findDetailById(Long id);
}
