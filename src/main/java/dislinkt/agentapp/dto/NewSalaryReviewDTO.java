package dislinkt.agentapp.dto;

import dislinkt.agentapp.model.Seniority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewSalaryReviewDTO {
    private String position;
    private Seniority seniority;
    private double monthlySalaryEur;
    private int companyId;
}
