package dislinkt.agentapp.repository;

import dislinkt.agentapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByName(String name);
}
