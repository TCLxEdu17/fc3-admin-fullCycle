package com.fullcycle.admin.catalogo.domain.exceptions;

public class NoStacktraceExeption extends RuntimeException {

    public NoStacktraceExeption(String message, Throwable cause) {

       // message, cause, enableSuppression, writableStackTrace
        //writableStackTrace diminui a performance da aplicacao

        super(message, cause, true, false);

    }

    public NoStacktraceExeption(String message) {

        this(message, null);    }
}
