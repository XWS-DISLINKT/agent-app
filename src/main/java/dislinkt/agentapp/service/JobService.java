package dislinkt.agentapp.service;

import dislinkt.agentapp.dto.JobDTO;
import dislinkt.agentapp.dto.NewJobDTO;

import java.util.List;

public interface JobService {

    List<JobDTO> getAllJobsForCompany(int companyId);

    List<JobDTO> getAllJobs();

    JobDTO createJob(NewJobDTO newJobDTO, String userEmail);
}
