package me.dio.desafio_de_projeto_portal_multisservicos.service.exception;

public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

}
