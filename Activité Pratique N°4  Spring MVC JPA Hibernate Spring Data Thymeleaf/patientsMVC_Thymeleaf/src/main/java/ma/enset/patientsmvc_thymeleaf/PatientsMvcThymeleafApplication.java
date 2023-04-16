package ma.enset.patientsmvc_thymeleaf;

import ma.enset.patientsmvc_thymeleaf.entities.Patient;
import ma.enset.patientsmvc_thymeleaf.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcThymeleafApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientsMvcThymeleafApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"ikram",new Date(), false, 210));
		patientRepository.save(new Patient(null,"imane",new Date(), true, 220));
		patientRepository.save(new Patient(null,"saad",new Date(), false, 412));
		patientRepository.save(new Patient(null,"afaf",new Date(), true, 512));
		patientRepository.save(new Patient(null,"rayane",new Date(), true, 679));
		patientRepository.save(new Patient(null,"bouchra",new Date(), false, 129));
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
