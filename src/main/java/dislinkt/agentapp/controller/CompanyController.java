package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.CompanyApprovalRequestDTO;
import dislinkt.agentapp.dto.CompanyDTO;
import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/company")
public class CompanyController {
    private final CompanyService companyService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping ("/unapproved")
    public List<CompanyDTO> getUnapprovedCompanies() {
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/response", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void respondToRequest(@RequestBody CompanyApprovalRequestDTO companyApprovalRequestDTO) {
        companyService.respondToRequest(companyApprovalRequestDTO);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerCompany(@RequestBody Company company, Principal user) {
        companyService.registerCompany(company, user.getName());
    }
    @PreAuthorize("hasRole('ROLE_COMPANY_OWNER')")
    @PostMapping(value = "/description", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateDescription(@RequestBody String description, Principal user) {
        companyService.updateDescription(description, user.getName());
    }
}
