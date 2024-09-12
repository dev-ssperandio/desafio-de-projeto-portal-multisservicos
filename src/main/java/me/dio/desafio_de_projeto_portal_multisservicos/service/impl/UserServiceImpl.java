package me.dio.desafio_de_projeto_portal_multisservicos.service.impl;

import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.Address;
import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.User;
import me.dio.desafio_de_projeto_portal_multisservicos.domain.repository.AddressRepository;
import me.dio.desafio_de_projeto_portal_multisservicos.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements me.dio.desafio_de_projeto_portal_multisservicos.service.UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public User createUser(User user) {
        if (userRepository.existsByCpf(user.getCpf())) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado com o CPF: " + user.getCpf());
        }

        Optional<Address> existingAddress = addressRepository.findByZipCodeAndStreetAndNumber(
                user.getAddress().getZipCode(),
                user.getAddress().getStreet(),
                user.getAddress().getNumber()
        );

        //existingAddress.ifPresent(user::setAddress);
        if (existingAddress.isPresent()) {
            user.setAddress(existingAddress.get());
        } else {
            Address newAddress = addressRepository.save(user.getAddress());
            user.setAddress(newAddress);
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userToUpdate = findUserById(id);

        Optional<Address> existingAddress = this.addressRepository.findByZipCodeAndStreetAndNumber(
                user.getAddress().getZipCode(),
                user.getAddress().getStreet(),
                user.getAddress().getNumber()
        );

        if (existingAddress.isPresent()) {
            userToUpdate.setAddress(existingAddress.get());
        } else {
            Address newAddress = addressRepository.save(user.getAddress());
            userToUpdate.setAddress(newAddress);
        }

        userToUpdate.setName(user.getName());
        userToUpdate.setCpf(user.getCpf());
        //userToUpdate.setAddress(user.getAddress());
        userToUpdate.setPackages(user.getPackages());
        return this.userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUserById(Long id) {
        User userToDelete = findUserById(id);
        this.userRepository.deleteById(id);
    }
}
