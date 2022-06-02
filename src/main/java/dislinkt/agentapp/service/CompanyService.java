package dislinkt.agentapp.service;

import dislinkt.agentapp.dto.CompanyDTO;
import dislinkt.agentapp.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getUnapprovedCompanies();
    List<CompanyDTO> getApprovedCompanies();
    CompanyDTO getCompanyById(int id);
}
