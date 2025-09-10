package com.fullcycle.admin.catalogo.application.category.create;

import com.fullcycle.admin.catalogo.domain.Category.Category;
import com.fullcycle.admin.catalogo.domain.Category.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
){
    public static CreateCategoryOutput fromCategory(Category aCategory) {
        return new CreateCategoryOutput(aCategory.getId());

    }
}

