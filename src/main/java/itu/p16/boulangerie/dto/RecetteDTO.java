package itu.p16.boulangerie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RecetteDTO {
    @JsonProperty("id_pt")
    private Integer idPt;
    private List<IngredientDTO> ingredients;

    // Getters et setters
    public Integer getIdPt() {
        return idPt;
    }

    public void setIdPt(Integer idPt) {
        this.idPt = idPt;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
