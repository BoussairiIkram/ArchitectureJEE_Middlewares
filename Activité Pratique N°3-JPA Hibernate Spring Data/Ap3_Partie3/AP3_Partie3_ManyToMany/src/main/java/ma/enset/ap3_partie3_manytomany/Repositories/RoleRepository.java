package ma.enset.ap3_partie3_manytomany.Repositories;

import ma.enset.ap3_partie3_manytomany.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String rolename);
}
