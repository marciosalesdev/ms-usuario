package com.marciosalesdev.usuario.infraestructure.exception;


public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String mensage) {
        super(mensage);
    }

    public ResourceNotFoundException(String mensage, Throwable cause) {
        super(mensage);
    }
}
