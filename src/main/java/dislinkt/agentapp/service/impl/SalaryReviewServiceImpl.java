package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.dto.NewSalaryReviewDTO;
import dislinkt.agentapp.dto.SalaryReviewGroupedDTO;
import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.model.SalaryReview;
import dislinkt.agentapp.model.User;
import dislinkt.agentapp.repository.CompanyRepository;
import dislinkt.agentapp.repository.SalaryReviewRepository;
import dislinkt.agentapp.service.SalaryReviewService;
import dislinkt.agentapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SalaryReviewServiceImpl implements SalaryReviewService {
    private final SalaryReviewRepository salaryReviewRepository;
    private final CompanyRepository companyRepository;
    private final UserService userService;

    @Override
    public List<SalaryReviewGroupedDTO> groupCompanySalaryReviews(Integer companyId) {
        return salaryReviewRepository.groupCompanySalaryReviews(companyId);
    }

    @Override
    public SalaryReview createSalaryReview(NewSalaryReviewDTO dto, String userEmail) {
        User user = userService.findByEmail(userEmail);
        Company company = companyRepository.findById(dto.getCompanyId()).orElse(null);
        SalaryReview newSalaryReview = SalaryReview.builder()
                .position(dto.getPosition())
                .company(company)
                .seniority(dto.getSeniority())
                .monthlySalaryEur(dto.getMonthlySalaryEur())
                .build();
        salaryReviewRepository.save(newSalaryReview);
        return newSalaryReview;
    }
}
