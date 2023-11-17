package com.example.cadastroescolar.repository;
import com.example.cadastroescolar.model.RegistroEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEntradaRepository extends JpaRepository<RegistroEntrada, Long> {
}
