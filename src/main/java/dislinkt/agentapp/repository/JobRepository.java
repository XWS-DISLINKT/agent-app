package dislinkt.agentapp.repository;

import dislinkt.agentapp.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
        List<Job> getByCompanyId(Integer companyId);
}
