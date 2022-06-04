package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.dto.SalaryReviewGroupedDTO;
import dislinkt.agentapp.repository.SalaryReviewRepository;
import dislinkt.agentapp.service.SalaryReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SalaryReviewServiceImpl implements SalaryReviewService {
    private final SalaryReviewRepository salaryReviewRepository;

    @Override
    public List<SalaryReviewGroupedDTO> groupCompanySalaryReviews(Integer companyId) {
        return salaryReviewRepository.groupCompanySalaryReviews(companyId);
    }
}
