package com.example.ap3_partie2_roles.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne
    @JoinColumn(name="patientId")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="medecinId")
    private Medecin medecin;
    @OneToOne
    @JoinColumn(name="consultationId")
    private Consultation consultation;
}
