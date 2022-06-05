package dislinkt.agentapp.dto;

import dislinkt.agentapp.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String email;
    private int companyId;
    private String role;
    private String connectionToken;

    public UserDTO(User user){
        id = user.getId();
        email = user.getEmail();
        companyId = -1;
        if(user.getCompany() != null)
            companyId = user.getCompany().getId();
        role = user.getRoles().get(0).getName();
        connectionToken = user.getConnectionToken();
    }
}
