package me.dio.desafio_de_projeto_portal_multisservicos.service;

import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.User;

import java.util.List;

public interface CrudService<ID, T> {

    T createUser(T entity);

    List<T> findAllUsers();

    T findUserById(ID id);

    T updateUser(ID id, T entity);

    void deleteUserById(ID id);
}
