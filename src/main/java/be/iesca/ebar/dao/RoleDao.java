package be.iesca.ebar.dao;

import be.iesca.ebar.domaine.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,String> {
}
