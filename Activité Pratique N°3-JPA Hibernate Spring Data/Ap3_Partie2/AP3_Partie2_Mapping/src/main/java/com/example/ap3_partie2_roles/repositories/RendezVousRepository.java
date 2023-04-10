package com.example.ap3_partie2_roles.repositories;

import com.example.ap3_partie2_roles.entities.Patient;
import com.example.ap3_partie2_roles.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
