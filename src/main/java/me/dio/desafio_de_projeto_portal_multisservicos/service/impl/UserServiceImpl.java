package me.dio.desafio_de_projeto_portal_multisservicos.service.impl;

import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.User;
import me.dio.desafio_de_projeto_portal_multisservicos.domain.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements me.dio.desafio_de_projeto_portal_multisservicos.service.UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        if (userRepository.existsByCpf(user.getCpf())) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado com o CPF: " + user.getCpf());
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userToUpdate = findUserById(id);
        BeanUtils.copyProperties(user, userToUpdate, "id");
        return userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUserById(Long id) {
        User userToDelete = findUserById(id);
        userRepository.deleteById(id);
    }
}
