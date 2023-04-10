package com.example.ap3_partie2_roles.services;

import com.example.ap3_partie2_roles.entities.Consultation;
import com.example.ap3_partie2_roles.entities.Medecin;
import com.example.ap3_partie2_roles.entities.Patient;
import com.example.ap3_partie2_roles.entities.RendezVous;

public interface IHospitalService {
    Patient patientSave(Patient patient);
    Medecin medecinSave(Medecin medecin);
    RendezVous rendezVousSave(RendezVous rendezVous);
    Consultation consultationSave(Consultation consultation);
}
