package dev.ose20.arknigthstoolui.controller;

import dev.ose20.arknigthstoolui.dto.Material;
import dev.ose20.arknigthstoolui.service.MaterialSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MaterialController {

    private final MaterialSvc materialSvc;

    public MaterialController(MaterialSvc materialSvc) {
        this.materialSvc = materialSvc;
    }

    @GetMapping("/materials")
    public String getMaterials(Model model) {
        List<Material> materials = materialSvc.findAll();
        model.addAttribute("materials", materials);

        return "material/list";
    }
}