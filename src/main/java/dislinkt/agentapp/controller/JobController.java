package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.JobDTO;
import dislinkt.agentapp.dto.NewJobDTO;
import dislinkt.agentapp.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/job")
public class JobController {
    private final JobService jobService;

    @GetMapping("/company/{companyId}")
    public List<JobDTO> getAllJobsForCompany(@PathVariable int companyId) {
        return jobService.getAllJobsForCompany(companyId);
    }

    @GetMapping("")
    public List<JobDTO> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PreAuthorize("hasRole('ROLE_COMPANY_OWNER')")
    @PostMapping("")
    public JobDTO createComment(@RequestBody NewJobDTO dto, Principal user) {
        return jobService.createJob(dto, user.getName());
    }
}
