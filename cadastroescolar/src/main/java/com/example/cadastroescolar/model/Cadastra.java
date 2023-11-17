package com.example.cadastroescolar.model;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Cadastra {
    @EmbeddedId
    private CadastraId id;

    @ManyToOne
    @MapsId("porteiroId") // Mapeamento para o atributo "porteiroId" em CadastraId
    private Porteiro porteiro;

    @ManyToOne
    @MapsId("alunoId") // Mapeamento para o atributo "alunoId" em CadastraId
    private Aluno aluno;

    @Embeddable
    public static class CadastraId implements Serializable {
        private Long porteiroId;
        private Long alunoId;
        
        // Construtores, getters e setters
    }
}
