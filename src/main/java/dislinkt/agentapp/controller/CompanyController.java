package dislinkt.agentapp.controller;

import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping ("/unapproved")
    public List<Company> getUnapprovedCompanies() {
        return companyService.getUnapprovedCompanies();
    }
}
