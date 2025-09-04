package com.fullcycle.admin.catalogo.domain.Category;

import com.fullcycle.admin.catalogo.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {

    private final String value;

    private CategoryID(String value) {
        Objects.requireNonNull(value, "CategoryID cannot be null");
        this.value = value;
    }

    //responsável por gerar um novo id
    public static CategoryID unique() {
        return CategoryID.from(UUID.randomUUID());
    }

    //factory methods que facilitam a utilizacao

    public static CategoryID from (final String anId){
        return new CategoryID(anId);

    }

    public static CategoryID from (final UUID anId){
        return new CategoryID(anId.toString().toLowerCase());

    }

    public String getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryID that = (CategoryID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue());
    }
}
