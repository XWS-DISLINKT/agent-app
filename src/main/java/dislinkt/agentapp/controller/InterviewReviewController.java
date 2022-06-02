package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.InterviewReviewDTO;
import dislinkt.agentapp.dto.NewInterviewReviewDTO;
import dislinkt.agentapp.service.InterviewReviewService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/interview-review")
public class InterviewReviewController {
    private final InterviewReviewService interviewReviewService;

    @GetMapping("/company/{companyId}")
    public List<InterviewReviewDTO> getAllInterviewReviewsForCompany(@PathVariable int companyId) {
        return interviewReviewService.getAllInterviewReviewsForCompany(companyId);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping("")
    public InterviewReviewDTO createComment(@RequestBody NewInterviewReviewDTO dto, Principal user) {
        return interviewReviewService.createInterviewReview(dto, user.getName());
    }

    @GetMapping("/avg-rating/{companyId}")
    public double getAverageRating(@PathVariable int companyId) {
        return interviewReviewService.getAvarageRating(companyId);
    }
}
