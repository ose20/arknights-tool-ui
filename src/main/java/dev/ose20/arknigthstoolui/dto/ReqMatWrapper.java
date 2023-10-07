package dev.ose20.arknigthstoolui.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ReqMatWrapper implements Serializable {
    private List<RequiredMaterial> reqMats = new ArrayList<>();

    public ReqMatWrapper reqMats(List<RequiredMaterial> val) {
        this.reqMats = val; return this;
    }
}
