package dislinkt.agentapp.dto;

import javax.validation.constraints.NotBlank;

public class BasicUserRegistration {
    @NotBlank
    String email;
    @NotBlank
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
