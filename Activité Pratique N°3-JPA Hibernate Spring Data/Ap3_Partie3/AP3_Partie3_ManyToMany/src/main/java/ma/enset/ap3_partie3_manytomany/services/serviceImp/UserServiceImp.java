package ma.enset.ap3_partie3_manytomany.services.serviceImp;

import jakarta.transaction.Transactional;
import ma.enset.ap3_partie3_manytomany.Repositories.RoleRepository;
import ma.enset.ap3_partie3_manytomany.Repositories.UserRepository;
import ma.enset.ap3_partie3_manytomany.entities.Role;
import ma.enset.ap3_partie3_manytomany.entities.User;
import ma.enset.ap3_partie3_manytomany.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional
public class UserServiceImp implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User addUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user= userRepository.findByUsername(userName);
        Role role = roleRepository.findByRoleName(roleName);

        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }


    }
}
