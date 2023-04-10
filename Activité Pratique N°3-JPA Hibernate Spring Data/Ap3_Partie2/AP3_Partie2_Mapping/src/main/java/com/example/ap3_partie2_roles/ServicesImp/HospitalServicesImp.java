package com.example.ap3_partie2_roles.ServicesImp;

import com.example.ap3_partie2_roles.entities.Consultation;
import com.example.ap3_partie2_roles.entities.Medecin;
import com.example.ap3_partie2_roles.entities.Patient;
import com.example.ap3_partie2_roles.entities.RendezVous;
import com.example.ap3_partie2_roles.repositories.ConsultationRepository;
import com.example.ap3_partie2_roles.repositories.MedecinRepository;
import com.example.ap3_partie2_roles.repositories.PatientRepository;
import com.example.ap3_partie2_roles.repositories.RendezVousRepository;
import com.example.ap3_partie2_roles.services.IHospitalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class HospitalServicesImp implements IHospitalService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Override
    public Patient patientSave(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin medecinSave(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous rendezVousSave(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation consultationSave(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
