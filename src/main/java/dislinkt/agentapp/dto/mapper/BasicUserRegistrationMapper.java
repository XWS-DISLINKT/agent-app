package dislinkt.agentapp.dto.mapper;

import dislinkt.agentapp.dto.BasicUserRegistration;
import dislinkt.agentapp.model.BasicUser;

public class BasicUserRegistrationMapper {
    public static BasicUser map(BasicUserRegistration dto) {
        return new BasicUser(dto.getEmail(), dto.getPassword());
    }
}
