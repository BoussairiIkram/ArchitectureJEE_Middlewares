package ma.enset.ap3jpa.repositories;

import ma.enset.ap3jpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
