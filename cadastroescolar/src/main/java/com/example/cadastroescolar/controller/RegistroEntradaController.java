package com.example.cadastroescolar.controller;

import com.example.cadastroescolar.model.RegistroEntrada;
import com.example.cadastroescolar.repository.RegistroEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
/*@CrossOrigin(origins = "http://localhost:5173")//Endereço do front*/
@RestController
@RequestMapping("/registroentrada")
public class RegistroEntradaController {
    @Autowired
    private RegistroEntradaRepository registroentradaRepository;
    @GetMapping
    public List<RegistroEntrada> listarRegistroEntrada() {
        return registroentradaRepository.findAll();
    }
    @PostMapping
    public RegistroEntrada criarVeiculo(@RequestBody RegistroEntrada registroentrada) {
        return registroentradaRepository.save(registroentrada);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarRegistroEntrada(@PathVariable Long id) {
        if (registroentradaRepository.existsById(id)) {
            registroentradaRepository.deleteById(id);
            return ResponseEntity.ok("Registroentrada deletado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroEntrada> atualizarRegistroEntrada(@PathVariable Long id, @RequestBody RegistroEntrada registroentradaAtualizado) {
        if (registroentradaRepository.existsById(id)) {
            RegistroEntrada registroentrada = registroentradaRepository.findById(id).get();
            registroentrada.setId(registroentradaAtualizado.getId());
            registroentrada.setData_hora(registroentradaAtualizado.getData_hora());
            registroentrada.setCpf(registroentradaAtualizado.getCpf());
            //faça os outros abaixo

            RegistroEntrada registroentradaAtualizadoBD = registroentradaRepository.save(registroentrada);
            return ResponseEntity.ok(registroentradaAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
