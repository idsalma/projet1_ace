package com.ace.example.ace.repository;

import com.ace.example.ace.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
