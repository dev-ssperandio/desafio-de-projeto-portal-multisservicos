package me.dio.desafio_de_projeto_portal_multisservicos.domain.repository;

import me.dio.desafio_de_projeto_portal_multisservicos.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByCpf(String cpf);
}
