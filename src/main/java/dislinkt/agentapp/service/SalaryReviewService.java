package dislinkt.agentapp.service;

import dislinkt.agentapp.dto.NewSalaryReviewDTO;
import dislinkt.agentapp.dto.SalaryReviewGroupedDTO;
import dislinkt.agentapp.model.SalaryReview;

import java.util.List;

public interface SalaryReviewService {
    SalaryReview createSalaryReview(NewSalaryReviewDTO dto, String userEmail);
    List<SalaryReviewGroupedDTO> groupCompanySalaryReviews(Integer companyId);
}
