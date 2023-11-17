package com.example.cadastroescolar.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rg;

    private String numCelular;
    private String dataNasc;
    private String nome;
    private String email;
    private Long id_matricula;
    private String cpf;
}
