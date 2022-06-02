package dislinkt.agentapp.repository;

import dislinkt.agentapp.model.InterviewReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewReviewRepository extends JpaRepository<InterviewReview, Integer> {
    List<InterviewReview> getByCompanyId(Integer companyId);
}
