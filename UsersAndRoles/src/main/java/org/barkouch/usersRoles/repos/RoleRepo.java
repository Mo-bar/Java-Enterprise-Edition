package org.barkouch.usersRoles.repos;



import org.barkouch.usersRoles.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, String> {
    Role findByRoleNameIgnoreCase(String roleName);

}
