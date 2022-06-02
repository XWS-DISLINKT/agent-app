package dislinkt.agentapp.service;

import dislinkt.agentapp.dto.InterviewReviewDTO;
import dislinkt.agentapp.dto.NewInterviewReviewDTO;

import java.util.List;

public interface InterviewReviewService {
    List<InterviewReviewDTO> getAllInterviewReviewsForCompany(int companyId);

    InterviewReviewDTO createInterviewReview(NewInterviewReviewDTO interviewReviewDTO, String userEmail);

    double getAvarageRating(int companyId);
}
