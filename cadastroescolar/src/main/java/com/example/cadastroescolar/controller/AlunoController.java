package com.example.cadastroescolar.controller;

import com.example.cadastroescolar.model.Aluno;
import com.example.cadastroescolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @DeleteMapping("/{rg}") // Correção: Use "rg" em vez de "id"
    public ResponseEntity<String> deletarAluno(@PathVariable Long rg) {
        if (alunoRepository.existsById(rg)) {
            alunoRepository.deleteById(rg);
            return ResponseEntity.ok("Aluno deletado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{rg}") // Correção: Use "rg" em vez de "id"
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long rg, @RequestBody Aluno alunoAtualizado) {
        if (alunoRepository.existsById(rg)) {
            Aluno aluno = alunoRepository.findById(rg).get();
            aluno.setRg(alunoAtualizado.getRg());
            aluno.setNumCelular(alunoAtualizado.getNumCelular());
            aluno.setEmail(alunoAtualizado.getEmail());
            aluno.setDataNasc(alunoAtualizado.getDataNasc());
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setIdmatricula(alunoAtualizado.getIdmatricula());

            Aluno alunoAtualizadoBD = alunoRepository.save(aluno);
            return ResponseEntity.ok(alunoAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
