package io.red.playground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "tbl_senha")
public class Senha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_senha")
    private UUID id;

    @Column(name = "senha")
    private Long senha;

    @Column(name = "senha_passwd", unique = true)
    private String passwd;

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Long getSenha() {
        return senha;
    }

    public void setSenha(Long senha) {
        this.senha = senha;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
