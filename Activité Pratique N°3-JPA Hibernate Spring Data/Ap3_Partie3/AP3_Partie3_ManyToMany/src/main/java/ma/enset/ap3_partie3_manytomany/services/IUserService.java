package ma.enset.ap3_partie3_manytomany.services;

import ma.enset.ap3_partie3_manytomany.entities.Role;
import ma.enset.ap3_partie3_manytomany.entities.User;

public interface IUserService {
    User addUser(User user);
    User findUserByUsername(String userName);

    Role addRole(Role role);
    Role findRoleByRoleName(String roleName);

    void addRoleToUser(String userName, String roleName);

}
