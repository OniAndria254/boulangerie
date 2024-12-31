package itu.p16.boulangerie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IngredientDTO {
    @JsonProperty("id_ig")
    private Integer idIg;
    private Double quantite;

    // Getters et setters
    public Integer getIdIg() {
        return idIg;
    }

    public void setIdIg(Integer idIg) {
        this.idIg = idIg;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }
}
