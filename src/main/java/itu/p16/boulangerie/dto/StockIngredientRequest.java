package itu.p16.boulangerie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class StockIngredientRequest {
    private List<IngredientEntry> ingredients;
    private LocalDate dateAjout;

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }

    public List<IngredientEntry> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntry> ingredients) {
        this.ingredients = ingredients;
    }

    public static class IngredientEntry {
        @JsonProperty("id_ingredient")
        private Integer idIngredient;
        private Double entree;

        public Integer getIdIngredient() {
            return idIngredient;
        }

        public void setIdIngredient(Integer idIngredient) {
            this.idIngredient = idIngredient;
        }

        public Double getEntree() {
            return entree;
        }

        public void setEntree(Double entree) {
            this.entree = entree;
        }
    }
}
