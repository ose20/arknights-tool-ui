package dev.ose20.arknigthstoolui.dto;

import lombok.Data;


@Data
public class Material {
    Long id;
    String name;
    Long rankId;
    Long moneyCost;
    Long staminaCost;

    public Material id(Long id) { this.id = id; return this; }
    public Material name(String name) { this.name = name; return this; }
    public Material rankId(Long rankId) { this.rankId = rankId; return this; }
    public Material moneyCost(Long moneyCost) { this.moneyCost = moneyCost; return this; }
    public Material staminaCost(Long staminaCost) { this.staminaCost = staminaCost; return this;}
}
