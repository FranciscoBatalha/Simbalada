package com.example.cadastroescolar.controller;

import com.example.cadastroescolar.model.Cadastra;
import com.example.cadastroescolar.repository.CadastraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173")//Endereço do front
@RestController
@RequestMapping("/cadastra")
public class CadastraController {
    @Autowired
    private CadastraRepository cadastraRepository;
    @GetMapping
    public List<Cadastra> listarCadstra() {
        return cadastraRepository.findAll();
    }
    @PostMapping
    public Cadastra criarVeiculo(@RequestBody Cadastra cadastra) {
        return cadastraRepository.save(cadastra);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCadastra(@PathVariable Long rg) {
        if (cadastraRepository.existsById(rg)) {
            cadastraRepository.deleteById(rg);
            return ResponseEntity.ok("Cadastra deletado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cadastra> atualizarCadstra(@PathVariable Long rg, @RequestBody Cadastra cadastraAtualizado) {
        if (cadastraRepository.existsById(rg)) {
            Cadastra cadastra = cadastraRepository.findById(rg).get();
            cadastra.setPorteiro(cadastraAtualizado.getPorteiro());
            cadastra.setAluno(cadastraAtualizado.getAluno());
            //faça os outros abaixo

            Cadastra cadastraAtualizadoBD = cadastraRepository.save(cadastra);
            return ResponseEntity.ok(cadastraAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
