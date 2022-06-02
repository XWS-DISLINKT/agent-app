package dislinkt.agentapp.repository;

import dislinkt.agentapp.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("SELECT c FROM Company c WHERE c.isApproved = false")
    List<Company> getUnapprovedCompanies();

    @Query("SELECT c FROM Company c WHERE c.isApproved = true")
    List<Company> getApprovedCompanies();
}
