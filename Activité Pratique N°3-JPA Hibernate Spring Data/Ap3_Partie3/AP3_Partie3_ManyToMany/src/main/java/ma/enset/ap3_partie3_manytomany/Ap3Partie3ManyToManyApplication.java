package ma.enset.ap3_partie3_manytomany;

import ma.enset.ap3_partie3_manytomany.entities.Role;
import ma.enset.ap3_partie3_manytomany.entities.User;
import ma.enset.ap3_partie3_manytomany.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ap3Partie3ManyToManyApplication implements CommandLineRunner {

    @Autowired
    IUserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Ap3Partie3ManyToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.addUser(new User(null, "ikram", "123", null ));
        userService.addUser(new User(null, "afaf", "123A", null ));
        userService.addUser(new User(null, "saad", "123S", null ));

        userService.addRole(new Role(null, "STUDENT", null ));
        userService.addRole(new Role(null, "USER", null ));
        userService.addRole(new Role(null, "ADMIN", null ));

        userService.addRoleToUser("ikram","ADMIN");
        userService.addRoleToUser("ikram","USER");
        userService.addRoleToUser("afaf","ADMIN");
        userService.addRoleToUser("saad","ADMIN");
        userService.addRoleToUser("saad","USER");
        userService.addRoleToUser("saad","STUDENT");

    }
}
