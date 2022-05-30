package dislinkt.agentapp.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BasicUserRegistration {
    @NotBlank
    String email;
    @NotBlank
    String password;
    @NotBlank
    String role;

}
