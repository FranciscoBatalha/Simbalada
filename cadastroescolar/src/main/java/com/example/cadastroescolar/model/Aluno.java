package com.example.cadastroescolar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aluno {

    @Id
    private Long rg;
    private String numCelular;
    private String email;
    private String dataNasc;
    private String nome;
    private Long idmatricula;
    private String cpf;
}
 