package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.dto.InterviewReviewDTO;
import dislinkt.agentapp.dto.JobDTO;
import dislinkt.agentapp.dto.NewJobDTO;
import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.model.InterviewReview;
import dislinkt.agentapp.model.Job;
import dislinkt.agentapp.model.User;
import dislinkt.agentapp.repository.CompanyRepository;
import dislinkt.agentapp.repository.JobRepository;
import dislinkt.agentapp.service.JobService;
import dislinkt.agentapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;
    private final UserService userService;
    @Override
    public List<JobDTO> getAllJobsForCompany(int companyId) {
        List<Job> jobs = jobRepository.getByCompanyId(companyId);
        List<JobDTO> jobDTOS = new ArrayList<>();
        for (Job ir: jobs) {
            jobDTOS.add(new JobDTO(ir));
        }
        return jobDTOS;
    }

    @Override
    public List<JobDTO> getAllJobs() {List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();
        for (Job ir: jobs) {
            jobDTOS.add(new JobDTO(ir));
        }
        return jobDTOS;
    }

    @Override
    public JobDTO createJob(NewJobDTO newJobDTO, String userEmail) {
        User user = userService.findByEmail(userEmail);
        Company company = user.getCompany();
        Job newJob = Job.builder()
                .position(newJobDTO.getPosition())
                .company(company)
                .seniority(newJobDTO.getSeniority())
                .location(newJobDTO.getLocation())
                .description(newJobDTO.getDescription())
                .closingDate(newJobDTO.getClosingDate())
                .build();
        jobRepository.save(newJob);
        return new JobDTO(newJob);
    }
}
