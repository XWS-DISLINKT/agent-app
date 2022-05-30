package dislinkt.agentapp.dto.mapper;

import dislinkt.agentapp.dto.BasicUserRegistration;
import dislinkt.agentapp.model.User;

public class BasicUserRegistrationMapper {
    public static User map(BasicUserRegistration dto) {
        return new User(dto.getEmail(), dto.getPassword());
    }
}
