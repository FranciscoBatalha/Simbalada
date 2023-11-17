package com.example.cadastroescolar.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class RegistroEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data_hora;
    private String cpf;

    @ManyToOne
    private Aluno aluno;
}
