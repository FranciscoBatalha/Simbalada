
package com.example.cadastroescolar.controller;

import com.example.cadastroescolar.model.Porteiro;
import com.example.cadastroescolar.repository.PorteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173")//Endereço do front
@RestController
@RequestMapping("/porteiro")
public class PorteiroController {
    @Autowired
    private PorteiroRepository porteiroRepository;
    @GetMapping
    public List<Porteiro> listarPorteiro() {
        return porteiroRepository.findAll();
    }
    @PostMapping
    public Porteiro criarVeiculo(@RequestBody Porteiro porteiro) {
        return porteiroRepository.save(porteiro);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarResponsavel(@PathVariable Long rg) {
        if (porteiroRepository.existsById(rg)) {
            porteiroRepository.deleteById(rg);
            return ResponseEntity.ok("Porteiro deletado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Porteiro> atualizarPorteiro(@PathVariable Long rg, @RequestBody Porteiro porteiroAtualizado) {
        if (porteiroRepository.existsById(rg)) {
            Porteiro porteiro = porteiroRepository.findById(rg).get();
            porteiro.setId(porteiroAtualizado.getId());
            porteiro.setNome(porteiroAtualizado.getNome());
            //faça os outros abaixo

            Porteiro porteiroAtualizadoBD = porteiroRepository.save(porteiro);
            return ResponseEntity.ok(porteiroAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
