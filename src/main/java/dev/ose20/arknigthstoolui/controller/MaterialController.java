package dev.ose20.arknigthstoolui.controller;

import dev.ose20.arknigthstoolui.dto.*;
import dev.ose20.arknigthstoolui.service.MaterialSvc;
import dev.ose20.arknigthstoolui.service.RankSvc;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/materials")
public class MaterialController {

    private final MaterialSvc materialSvc;
    private final RankSvc rankSvc;


    public MaterialController(MaterialSvc materialSvc, RankSvc rankSvc) {
        this.materialSvc = materialSvc;
        this.rankSvc = rankSvc;
    }

    @GetMapping
    public String getMaterials(Model model) {
        List<Material> materials = materialSvc.findAll();
        Collections.reverse(materials);
        model.addAttribute("materials", materials);

        return "material/list";
    }

    @GetMapping("/{id}")
    public String getMaterialDetail(@PathVariable Long id, Model model) {
        MaterialDetail materialDetail = materialSvc.findDetailById(id);
        Rank rank = rankSvc.findById(materialDetail.getMaterial().getRankId());
        model.addAttribute("materialDetail", materialDetail);
        model.addAttribute("rank", rank);
        return "material/detail";
    }

    @GetMapping("/calculator")
    public String showCalculator(Model model) {
        List<Material> materials = materialSvc.findAll();
        Collections.reverse(materials);

        List<RequiredMaterial> requiredMaterials = materials.stream()
                .map(m -> {
                    var res = new RequiredMaterial();
                    res.setMaterialId(m.getId());
                    res.setName(m.getName());
                    res.setQuantity(0);
                    return res;
                })
                .toList();

        var reqMatWrapper = new ReqMatWrapper();
        reqMatWrapper.setReqMats(requiredMaterials);
        model.addAttribute("reqMatWrapper", reqMatWrapper);

        return "material/calculator";
    }

    @PostMapping("/decompose")
    public String calcRequirements(
            @ModelAttribute ReqMatWrapper reqMatWrapper,
            RedirectAttributes redirectAttributes) {
        List<RequiredMaterial> reqMats = reqMatWrapper.getReqMats().stream()
                        .filter(rm -> rm.getQuantity() > 0).toList();


        redirectAttributes.addFlashAttribute(
                "reqMatWrapper", reqMatWrapper
        );

        redirectAttributes.addFlashAttribute(
                "resMats",
                new ReqMatWrapper().reqMats(materialSvc.decomposeReqMats(reqMats))
        );


        // リダイレクトを検討。その場合はセッションやフラッシュスコープが必要かも
        return "redirect:/material/calculator";
    }
}