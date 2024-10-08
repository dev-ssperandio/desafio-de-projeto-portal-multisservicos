package me.dio.desafio_de_projeto_portal_multisservicos.domain.repository;

import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.Address;
import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByCpf(String cpf);

    List<User> findByAddress(Address address);

}
