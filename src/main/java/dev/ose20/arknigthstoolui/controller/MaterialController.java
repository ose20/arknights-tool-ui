package dev.ose20.arknigthstoolui.controller;

import dev.ose20.arknigthstoolui.dto.Material;
import dev.ose20.arknigthstoolui.dto.MaterialDetail;
import dev.ose20.arknigthstoolui.dto.Rank;
import dev.ose20.arknigthstoolui.service.MaterialSvc;
import dev.ose20.arknigthstoolui.service.RankSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class MaterialController {

    private final MaterialSvc materialSvc;
    private final RankSvc rankSvc;

    public MaterialController(MaterialSvc materialSvc, RankSvc rankSvc) {
        this.materialSvc = materialSvc;
        this.rankSvc = rankSvc;
    }

    @GetMapping("/materials")
    public String getMaterials(Model model) {
        List<Material> materials = materialSvc.findAll();
        Collections.reverse(materials);
        model.addAttribute("materials", materials);

        return "material/list";
    }

    @GetMapping("/materials/{id}")
    public String getMaterialDetail(@PathVariable Long id, Model model) {
        MaterialDetail materialDetail = materialSvc.findDetailById(id);
        Rank rank = rankSvc.findById(materialDetail.getMaterial().getRankId());
        model.addAttribute("materialDetail", materialDetail);
        model.addAttribute("rank", rank);
        return "material/detail";
    }
}