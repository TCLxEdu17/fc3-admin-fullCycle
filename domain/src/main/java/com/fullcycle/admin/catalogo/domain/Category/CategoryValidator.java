package com.fullcycle.admin.catalogo.domain.Category;

import com.fullcycle.admin.catalogo.domain.validation.Error;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.validation.Validator;

public class CategoryValidator extends Validator {

    public static final int MAX_SIZE = 255;
    public static final int MIN_SIZE = 3;
    private final Category category;


    public CategoryValidator(Category aCategory, ValidationHandler aHandler) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {

        final var name = this.category.getName();

        if(name == null){
            this.validationHandler().append(new Error("'name' should not be null"));
        }
        if(name.isBlank()){
            this.validationHandler().append(new Error("'name' should not be empty"));
        }

        final int length = name.trim().length();
        if(length > MAX_SIZE || length < MIN_SIZE){
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters "));
        }

    }

}
