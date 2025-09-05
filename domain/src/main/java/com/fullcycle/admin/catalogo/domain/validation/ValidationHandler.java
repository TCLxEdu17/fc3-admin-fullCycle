package com.fullcycle.admin.catalogo.domain.validation;

public interface ValidationHandler {

    ValidationHandler append( Error anError);
    ValidationHandler append( ValidationHandler anHandler);
    ValidationHandler validate( Validation validation);


    public interface Validation{
        void validate();
    }



}
