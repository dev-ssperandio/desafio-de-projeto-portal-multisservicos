package me.dio.desafio_de_projeto_portal_multisservicos.service;

import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.User;
import me.dio.desafio_de_projeto_portal_multisservicos.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> findAllUsers();

    User findUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUserById(Long id);
}
