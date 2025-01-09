package com.desafio.banco.services.exceptions;

public class ForbiddenException extends RuntimeException
{
    public ForbiddenException(String msg) {

        super(msg);
    }
}
