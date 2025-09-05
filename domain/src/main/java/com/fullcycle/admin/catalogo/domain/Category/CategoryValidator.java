package com.fullcycle.admin.catalogo.domain.Category;

import com.fullcycle.admin.catalogo.domain.validation.Error;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;


    public CategoryValidator(Category aCategory, ValidationHandler aHandler) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {

        if(category.getName() == null || category.getName().isEmpty() || category.getName().isBlank()){
            this.validationHandler().append(new Error("'name' should not be null"));
        }


    }
}
