package me.dio.desafio_de_projeto_portal_multisservicos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.Address;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByZipCodeAndStreetAndNumber(String zipCode, String street, String number);
}
