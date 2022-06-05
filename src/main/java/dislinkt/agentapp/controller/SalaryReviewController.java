package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.JobDTO;
import dislinkt.agentapp.dto.NewJobDTO;
import dislinkt.agentapp.dto.NewSalaryReviewDTO;
import dislinkt.agentapp.dto.SalaryReviewGroupedDTO;
import dislinkt.agentapp.model.SalaryReview;
import dislinkt.agentapp.service.SalaryReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/salary-reviews")
public class SalaryReviewController {
    private final SalaryReviewService salaryReviewService;

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<SalaryReviewGroupedDTO>> groupCompanySalaryReviews(@PathVariable Integer companyId) {
        List<SalaryReviewGroupedDTO> salaryReviewGrouped = salaryReviewService.groupCompanySalaryReviews(companyId);
        if (salaryReviewGrouped != null) {
            return new ResponseEntity<>(salaryReviewGrouped, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping("")
    public SalaryReview createComment(@RequestBody NewSalaryReviewDTO dto, Principal user) {
        return salaryReviewService.createSalaryReview(dto, user.getName());
    }
}
