package dislinkt.agentapp.service;

import dislinkt.agentapp.dto.SalaryReviewGroupedDTO;

import java.util.List;

public interface SalaryReviewService {

    List<SalaryReviewGroupedDTO> groupCompanySalaryReviews(Integer companyId);
}
