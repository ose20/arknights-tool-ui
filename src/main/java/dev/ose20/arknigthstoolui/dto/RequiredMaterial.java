package dev.ose20.arknigthstoolui.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class RequiredMaterial implements Serializable {
    private Long materialId;
    private String name;
    private Integer quantity;

    public RequiredMaterial materialId(Long val) {
        this.materialId = val; return this;
    }

    public RequiredMaterial name(String val) {
        this.name = val; return this;
    }

    public RequiredMaterial quantity(Integer val) {
        this.quantity = val; return this;
    }
}


