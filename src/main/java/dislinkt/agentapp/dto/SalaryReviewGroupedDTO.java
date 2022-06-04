package dislinkt.agentapp.dto;

import dislinkt.agentapp.model.Seniority;

public interface SalaryReviewGroupedDTO {
    String getPosition();
    Seniority getSeniority();
    Double getAverageMonthlySalary();
    Double getMinMonthlySalary();
    Double getMaxMonthlySalary();
    Integer getNumberOfReviews();
}
