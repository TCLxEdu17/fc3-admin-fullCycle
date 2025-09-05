package com.fullcycle.admin.catalogo.domain.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append( Error anError);
    ValidationHandler append( ValidationHandler anHandler);
    ValidationHandler validate( Validation validation);


    public interface Validation{
        void validate();
    }

    List<Error> getErrors();

    default boolean hasErrors() {
        return getErrors() != null && getErrors().isEmpty();
    }



}
