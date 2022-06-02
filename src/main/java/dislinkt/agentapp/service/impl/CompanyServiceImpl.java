package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.dto.CompanyDTO;
import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.repository.CompanyRepository;
import dislinkt.agentapp.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    @Override
    public List<Company> getUnapprovedCompanies() {
        return companyRepository.getUnapprovedCompanies();
    }

    @Override
    public List<CompanyDTO> getApprovedCompanies()  {
        List<Company> companies = companyRepository.getApprovedCompanies();
        List<CompanyDTO> companiesDto = new ArrayList<>();
        for (Company c : companies) {
            companiesDto.add(new CompanyDTO(c, 0.0));
        }
        return companiesDto;
    }
}
