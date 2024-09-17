package me.dio.desafio_de_projeto_portal_multisservicos.service.exception;

public class NotFoundException extends BusinessException {

    private static final long serialVersionUID = 1l;

    public NotFoundException() {
        super("Recurso não encontrado.");
    }

}
