package dislinkt.agentapp.dto;

import dislinkt.agentapp.model.Seniority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewJobDTO {
    private String position;
    private Seniority seniority;
    private String location;
    private String description;
    private Date closingDate;
}
