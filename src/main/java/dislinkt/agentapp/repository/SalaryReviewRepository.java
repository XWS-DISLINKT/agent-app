package dislinkt.agentapp.repository;

import dislinkt.agentapp.dto.SalaryReviewGroupedDTO;
import dislinkt.agentapp.model.SalaryReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalaryReviewRepository extends JpaRepository<SalaryReview, Integer> {

    @Query(value = "SELECT s.position, s.seniority, AVG(s.monthly_salary_eur) as averageMonthlySalary, " +
           "MIN(s.monthly_salary_eur) as minMonthlySalary, MAX(s.monthly_salary_eur) as maxMonthlySalary, " +
           "COUNT(s.monthly_salary_eur) as numberOfReviews " +
           "FROM salary_reviews s " +
           "WHERE s.company_id = ?1 " +
           "GROUP BY s.position, s.seniority " +
           "ORDER BY numberOfReviews DESC", nativeQuery = true)
    List<SalaryReviewGroupedDTO> groupCompanySalaryReviews(Integer companyId);
}
