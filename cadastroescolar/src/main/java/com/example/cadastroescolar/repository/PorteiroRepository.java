package com.example.cadastroescolar.repository;
import com.example.cadastroescolar.model.Porteiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorteiroRepository extends JpaRepository<Porteiro, Long> {
}
