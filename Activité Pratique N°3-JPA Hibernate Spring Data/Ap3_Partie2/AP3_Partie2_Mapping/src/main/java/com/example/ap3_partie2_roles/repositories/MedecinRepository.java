package com.example.ap3_partie2_roles.repositories;

import com.example.ap3_partie2_roles.entities.Medecin;
import com.example.ap3_partie2_roles.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
