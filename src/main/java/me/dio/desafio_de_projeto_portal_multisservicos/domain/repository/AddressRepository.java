package me.dio.desafio_de_projeto_portal_multisservicos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.Address;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByZipCodeAndStreetAndNumber(String zipCode, String street, String number);
}
