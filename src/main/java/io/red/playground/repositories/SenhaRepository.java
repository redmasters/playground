package io.red.playground.repositories;

import io.red.playground.model.Senha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {

    Optional<Senha> findFirstByOrderBySenhaDesc();

}
