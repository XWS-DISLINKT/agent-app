package dislinkt.agentapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyApprovalRequestDTO {
    private Integer companyId;
    private Boolean isApproved;
}
