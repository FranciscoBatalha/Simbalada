
package com.example.cadastroescolar.controller;

import com.example.cadastroescolar.model.Responsavel;
import com.example.cadastroescolar.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173")//Endereço do front
@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {
    @Autowired
    private ResponsavelRepository responsavelRepository;
    @GetMapping
    public List<Responsavel> listarResponsavel() {
        return responsavelRepository.findAll();
    }
    @PostMapping
    public Responsavel criarVeiculo(@RequestBody Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarResponsavel(@PathVariable Long rg) {
        if (responsavelRepository.existsById(rg)) {
            responsavelRepository.deleteById(rg);
            return ResponseEntity.ok("Responsavel deletado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> atualizarResponsavel(@PathVariable Long rg, @RequestBody Responsavel responsavelAtualizado) {
        if (responsavelRepository.existsById(rg)) {
            Responsavel responsavel = responsavelRepository.findById(rg).get();
            responsavel.setRg(responsavelAtualizado.getRg());
            responsavel.setNumCelular(responsavelAtualizado.getNumCelular());
            //faça os outros abaixo

            Responsavel responsavelAtualizadoBD = responsavelRepository.save(responsavel);
            return ResponseEntity.ok(responsavelAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
