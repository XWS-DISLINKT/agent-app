package dislinkt.agentapp.service;

import dislinkt.agentapp.dto.BasicUserRegistration;
import dislinkt.agentapp.model.User;

public interface UserService {

    User findByEmail(String email);

    User register(BasicUserRegistration basicUserRegistration);

}
