package dislinkt.agentapp.dto;

import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.model.EmployeesNumberRange;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDTO {
    private Integer id;
    private String name;
    private EmployeesNumberRange employeesNumberRange;
    private String industry;
    private String email;
    private String phoneNumber;
    private String about;
    private double rating;
    private String location;

    public CompanyDTO(Company company, double rating){
        id = company.getId();
        name = company.getName();
        employeesNumberRange = company.getEmployeesNumberRange();
        industry = company.getIndustry();
        email = company.getEmail();
        phoneNumber = company.getPhoneNumber();
        about = company.getAbout();
        this.rating = rating;
        location = company.getLocation();
    }
}
