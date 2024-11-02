package com.ace.example.ace.entity;

import com.ace.example.ace.enumeration.TypeCompte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.ORDINAL)
    private TypeCompte type;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getSolde() {
        return solde;
    }

    public TypeCompte getType() {
        return type;
    }

}
