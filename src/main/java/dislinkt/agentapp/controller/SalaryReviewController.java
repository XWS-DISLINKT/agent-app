package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.SalaryReviewGroupedDTO;
import dislinkt.agentapp.service.SalaryReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
