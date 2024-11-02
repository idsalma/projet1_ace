package com.ace.example.ace.service;

import com.ace.example.ace.entity.Compte;
import com.ace.example.ace.repository.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")

public class CompteRestJaxRSAPI {
    @Autowired
    private CompteRepository compteRepository;
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> getComptes(){

        return compteRepository.findAll();
    }
    //recuperer compte par identifiant
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte getCompte(@PathParam("id") Long id){

        return compteRepository.findById(id).orElse(null);
    }

    @Path("/comptes")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte addCompte(Compte compte){

        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte updateCompte(@PathParam("id") Long id, Compte compte){
        Compte compteExist = compteRepository.findById(id).orElse(null);
        if(compteExist != null){
            compteExist.setSolde(compte.getSolde());
            compteExist.setDate(compte.getDate());
            compteExist.setType(compte.getType());
            return compteRepository.save(compteExist);
        }
        return null;
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteCompte(@PathParam("id") Long id){

        compteRepository.deleteById(id);
    }






}
