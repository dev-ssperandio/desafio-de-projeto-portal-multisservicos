package me.dio.desafio_de_projeto_portal_multisservicos.service;

import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.User;
import me.dio.desafio_de_projeto_portal_multisservicos.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // create/ read/ update/ delete
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user) {
        Optional<User> userToUpdate = findUserById(id);
        if (userToUpdate.isPresent()) {
            User userToSave = userToUpdate.get();
            userToSave.setName(user.getName());
            userToSave.setCpf(user.getCpf());
            userToSave.setAddress(user.getAddress());
            userToSave.setPackages(user.getPackages());
            return userRepository.save(userToSave);
        } else {
            throw new NoSuchElementException("Usuário não encontrado");
        }
    }

    public void deleteUserById(Long id) {
        Optional<User> userToDelete = findUserById(id);
        if (userToDelete.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Usuário não encontrado");
        }
    }
}
