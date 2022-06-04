package dislinkt.agentapp.dto;

import dislinkt.agentapp.model.Job;
import dislinkt.agentapp.model.Seniority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
    private Integer id;
    private String position;
    private String companyName;
    private Seniority seniority;
    private String location;
    private String description;
    private Date closingDate;

    public JobDTO(Job job){
        id = job.getId();
        position = job.getPosition();
        companyName = job.getCompany().getName();
        seniority = job.getSeniority();
        location = job.getLocation();
        description = job.getDescription();
        closingDate = job.getClosingDate();
    }
}
