package dislinkt.agentapp.repository;

import dislinkt.agentapp.model.BasicUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicUserRepository extends JpaRepository<BasicUser, Integer> {

}
