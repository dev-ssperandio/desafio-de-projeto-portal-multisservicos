package me.dio.desafio_de_projeto_portal_multisservicos.service.impl;

import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.*;
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

        if (existingAddress.isPresent()) {
            user.setAddress(existingAddress.get());
        } else {
            Address newAddress = addressRepository.save(user.getAddress());
            user.setAddress(newAddress);
        }

        checkForDuplicateServices(user);

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

        checkForDuplicateServices(user);

        userToUpdate.setName(user.getName());
        userToUpdate.setCpf(user.getCpf());
        userToUpdate.setPackages(user.getPackages());

        return this.userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUserById(Long id) {
        User userToDelete = findUserById(id);
        this.userRepository.deleteById(id);
    }

    private void checkForDuplicateServices(User user) {
        for (ServicePackage servicePackage : user.getPackages()) {
            if (servicePackage instanceof BroadbandPackage || servicePackage instanceof TVPackage) {
                for (ServicePackage existingPackage : user.getPackages()) {
                    if (existingPackage != servicePackage &&
                            ((existingPackage instanceof BroadbandPackage && servicePackage instanceof BroadbandPackage) ||
                                    (existingPackage instanceof TVPackage && servicePackage instanceof TVPackage))) {
                        throw new IllegalArgumentException("O usuário já possui um serviço de " + servicePackage.getClass().getSimpleName() + ".");
                    }
                }
                List<User> usersAtSameAddress = userRepository.findByAddress(user.getAddress());
                for (User existingUser : usersAtSameAddress) {
                    if  (!existingUser.getId().equals(user.getId())) {
                        
                        for (ServicePackage existingPackage : existingUser.getPackages()) {
                            if ((existingPackage instanceof BroadbandPackage && servicePackage instanceof BroadbandPackage) ||
                                    (existingPackage instanceof TVPackage && servicePackage instanceof TVPackage)) {
                                throw new IllegalArgumentException("Já existe um serviço de " + servicePackage.getClass().getSimpleName() + " registrado para este endereço.");
                            }
                        }
                    }
                }
            }
        }
    }
}
