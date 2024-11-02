package com.ace.example.ace;

import com.ace.example.ace.entity.Compte;
import com.ace.example.ace.enumeration.TypeCompte;
import com.ace.example.ace.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class AceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CompteRepository compteRepository) {
		return args -> {
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE));
			compteRepository.findAll().forEach(compte -> {
				System.out.println(compte);
			});

		};
	}
}
//http://localhost:8082/banque/comptes
//curl -X GET "http://localhost:8082/banque/compes" -H "Accept: application/json