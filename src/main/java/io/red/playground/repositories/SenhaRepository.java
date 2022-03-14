package io.red.playground.repositories;

import io.red.playground.model.Senha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long> {

    @Query(value = "SELECT * " + "FROM TBL_SENHAS AS TS " +
        "WHERE SENHA = (SELECT MAX FROM TS)", nativeQuery = true)
    Senha findMax();

}
