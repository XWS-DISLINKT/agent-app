package dislinkt.agentapp.service;

import dislinkt.agentapp.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getUnapprovedCompanies();
}
