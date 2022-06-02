package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.CompanyDTO;
import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/company")
public class CompanyController {
    private final CompanyService companyService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping ("/unapproved")
    public List<Company> getUnapprovedCompanies() {
        return companyService.getUnapprovedCompanies();
    }

    @GetMapping ("/approved")
    public List<CompanyDTO> getAllApprovedCompanies() {
        return companyService.getApprovedCompanies();
    }
    @GetMapping ("/{id}")
    public CompanyDTO getCompanyById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }
}
