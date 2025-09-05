package com.fullcycle.admin.catalogo.domain.exceptions;

import com.fullcycle.admin.catalogo.domain.validation.Error;

import java.util.List;

public class DomainException extends NoStacktraceExeption {

    private final List<Error> errors;

    //evitar colocar stacktrace completa para melhoria de performance
    private DomainException(final String aMessage, final List<Error> anErrors) {
        super(" ");
        this.errors = anErrors ;
    }

    public static DomainException with(final List<Error> anErrors){
        return new DomainException("", anErrors);

    }

    public List<Error> getErrors() {
        return errors;
    }

    public static DomainException with(final Error anErrors){
        return new DomainException(anErrors.message(), List.of(anErrors));
    }
}
