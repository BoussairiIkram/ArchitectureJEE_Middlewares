package ma.enset.ap3_partie3_manytomany.Repositories;

import ma.enset.ap3_partie3_manytomany.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String userName);
}
