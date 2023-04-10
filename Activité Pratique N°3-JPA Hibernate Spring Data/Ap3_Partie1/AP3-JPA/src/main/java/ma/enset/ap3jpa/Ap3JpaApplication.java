package ma.enset.ap3jpa;

import ma.enset.ap3jpa.entities.Patient;
import ma.enset.ap3jpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Ap3JpaApplication  implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ap3JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"ikram", new Date(), false, 56));
		patientRepository.save(new Patient(null,"afaf", new Date(), false, 196));
		patientRepository.save(new Patient(null,"rayane", new Date(), false, 5));

/*
		List<Patient> patients= patientRepository.findAll();
		patients.forEach( patient -> {
			System.out.println("----------");
			System.out.println(patient.getId());
			System.out.println(patient.getNom());
			System.out.println(patient.getDateNaissance());
			System.out.println(patient.getScore());
			System.out.println(patient.isMalade());
		});

		Patient patient = patientRepository.findById(1L).get();
		patient.setScore(1000);
		patientRepository.save(patient);

		if(patient!=null){
			System.out.println("----------");
			System.out.println(patient.getNom());
			System.out.println(patient.getDateNaissance());
			System.out.println(patient.getScore());
			System.out.println(patient.isMalade());
		}
 */
		patientRepository.deleteById(2L);

	}
}
