package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.dto.InterviewReviewDTO;
import dislinkt.agentapp.dto.NewInterviewReviewDTO;
import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.model.InterviewReview;
import dislinkt.agentapp.model.User;
import dislinkt.agentapp.repository.CompanyRepository;
import dislinkt.agentapp.repository.InterviewReviewRepository;
import dislinkt.agentapp.service.InterviewReviewService;
import dislinkt.agentapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class InterviewReviewServiceImpl implements InterviewReviewService {
    private final InterviewReviewRepository interviewReviewRepository;
    private final CompanyRepository companyRepository;
    private final UserService userService;

    @Override
    public List<InterviewReviewDTO> getAllInterviewReviewsForCompany(int companyId) {
        List<InterviewReview> interviewReviews = interviewReviewRepository.getByCompanyId(companyId);
        List<InterviewReviewDTO> interviewReviewsDto = new ArrayList<>();
        for (InterviewReview ir: interviewReviews) {
            interviewReviewsDto.add(new InterviewReviewDTO(ir));
        }
        return interviewReviewsDto;
    }

    @Override
    public InterviewReviewDTO createInterviewReview(NewInterviewReviewDTO interviewReviewDTO, String userEmail) {
        User user = userService.findByEmail(userEmail);
        Company company = companyRepository.findById(interviewReviewDTO.getCompanyId()).orElse(null);
        InterviewReview newInterviewReview = InterviewReview.builder()
                .author(user)
                .company(company)
                .title(interviewReviewDTO.getTitle())
                .rating(interviewReviewDTO.getRating())
                .hrInterview(interviewReviewDTO.getHrInterview())
                .technicalInterview(interviewReviewDTO.getTechnicalInterview())
                .datePosted(new Date())
                .difficulty(interviewReviewDTO.getDifficulty())
                .selectionProcessDurationInWeeks(2.9)
                .build();
        interviewReviewRepository.save(newInterviewReview);
        return new InterviewReviewDTO(newInterviewReview);
    }

    @Override
    public double getAvarageRating(int companyId) {
        List<InterviewReview> interviewReviews = interviewReviewRepository.getByCompanyId(companyId);
        double sum = 0;
        int i = 0;
        for (InterviewReview ir : interviewReviews) {
            sum += ir.getRating();
            i++;
        }
        if (sum == 0)
            return 0.0;
        return sum/i;
    }
}
