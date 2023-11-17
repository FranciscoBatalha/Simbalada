package com.example.cadastroescolar.repository;
import com.example.cadastroescolar.model.Cadastra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastraRepository extends JpaRepository<Cadastra, Long> {
}

