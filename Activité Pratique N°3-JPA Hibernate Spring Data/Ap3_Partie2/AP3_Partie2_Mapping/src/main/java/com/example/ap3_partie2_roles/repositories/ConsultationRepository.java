package com.example.ap3_partie2_roles.repositories;

import com.example.ap3_partie2_roles.entities.Consultation;
import com.example.ap3_partie2_roles.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
