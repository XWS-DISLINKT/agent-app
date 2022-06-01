package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.repository.CompanyRepository;
import dislinkt.agentapp.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    @Override
    public List<Company> getUnapprovedCompanies() {
        return companyRepository.getUnapprovedCompanies();
    }
}
