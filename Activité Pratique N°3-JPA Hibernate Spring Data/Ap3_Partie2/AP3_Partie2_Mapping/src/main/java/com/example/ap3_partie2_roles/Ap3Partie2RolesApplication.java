package com.example.ap3_partie2_roles;

import com.example.ap3_partie2_roles.entities.*;
import com.example.ap3_partie2_roles.repositories.ConsultationRepository;
import com.example.ap3_partie2_roles.repositories.MedecinRepository;
import com.example.ap3_partie2_roles.repositories.PatientRepository;
import com.example.ap3_partie2_roles.repositories.RendezVousRepository;
import com.example.ap3_partie2_roles.services.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Ap3Partie2RolesApplication implements CommandLineRunner {

   @Autowired
  private  IHospitalService hospitalService;
   @Autowired
   private MedecinRepository medecinRepository;
   @Autowired
   private PatientRepository patientRepository;

   @Autowired
   private RendezVousRepository rendezVousRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ap3Partie2RolesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        hospitalService.patientSave(new Patient(null,"ikram", new Date(),null));
        hospitalService.patientSave(new Patient(null,"imane", new Date(),null));
        hospitalService.patientSave(new Patient(null,"afaf", new Date(),null));

        hospitalService.medecinSave(new Medecin(null,"rayane","rayane@gmail.com","Generaliste",null));
        hospitalService.medecinSave(new Medecin(null,"rim","rim@gmail.com","Cardiologue",null));
        hospitalService.medecinSave(new Medecin(null,"sara","sara@gmail.com","Dentist",null));

        Medecin medecin=medecinRepository.findById(1L).orElse(null);
        Patient patient= patientRepository.findById(3L).orElse(null);

        hospitalService.rendezVousSave(new RendezVous(null, new Date(), StatusRDV.PENDING,patient, medecin,null));

        RendezVous rendezVous = rendezVousRepository.findById(1L).orElse(null);

        Consultation consultation = new Consultation(null, new Date(), "dfdfdfziiiiiiiii", rendezVous);
        hospitalService.consultationSave(consultation);

        rendezVous.setConsultation(consultation);
        hospitalService.rendezVousSave(rendezVous);

    }
}
