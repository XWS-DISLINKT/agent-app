package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.dto.CompanyApprovalRequestDTO;
import dislinkt.agentapp.dto.CompanyDTO;
import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.model.User;
import dislinkt.agentapp.repository.CompanyRepository;
import dislinkt.agentapp.repository.RoleRepository;
import dislinkt.agentapp.repository.UserRepository;
import dislinkt.agentapp.service.CommentService;
import dislinkt.agentapp.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CommentService commentService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public List<CompanyDTO> getUnapprovedCompanies() {
        List<Company> companies = companyRepository.getUnapprovedCompanies();
        List<CompanyDTO> companiesDto = new ArrayList<>();
        for (Company c : companies) {
            companiesDto.add(new CompanyDTO(c, commentService.getAvarageRating(c.getId())));
        }
        return companiesDto;
    }

    @Override
    public List<CompanyDTO> getApprovedCompanies()  {
        List<Company> companies = companyRepository.getApprovedCompanies();
        List<CompanyDTO> companiesDto = new ArrayList<>();
        for (Company c : companies) {
            companiesDto.add(new CompanyDTO(c, commentService.getAvarageRating(c.getId())));
        }
        return companiesDto;
    }

    @Override
    public CompanyDTO getCompanyById(int id) {
        Company company = companyRepository.findById(id).orElse(null);
        if(company == null || !company.isApproved())
            return null;
        return new CompanyDTO(company, commentService.getAvarageRating(company.getId()));
    }

    @Override
    public void respondToRequest(CompanyApprovalRequestDTO companyApprovalRequestDTO) {
        Company c = companyRepository.findById(companyApprovalRequestDTO.getCompanyId()).get();
        c.setApproved(companyApprovalRequestDTO.getIsApproved());
        companyRepository.save(c);
        if (companyApprovalRequestDTO.getIsApproved()) {
            User u = userRepository.findByCompanyId(c.getId());
            u.setRoles(roleRepository.findByName("ROLE_COMPANY_OWNER"));
            userRepository.save(u);
        }
    }

    @Override
    public void registerCompany(Company company, String email) {
        Company c = companyRepository.save(company);
        User u = userRepository.findByEmail(email);
        u.setCompany(c);
        userRepository.save(u);
    }

    @Override
    public void updateDescription(String description, String email) {
        User u = userRepository.findByEmail(email);
        Company c = companyRepository.findById(u.getCompany().getId()).get();
        c.setAbout(description);
        companyRepository.save(c);
    }

}
