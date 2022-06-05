package dislinkt.agentapp.service;

import dislinkt.agentapp.dto.BasicUserRegistration;
import dislinkt.agentapp.dto.UserDTO;
import dislinkt.agentapp.model.User;

public interface UserService {

    User findByEmail(String email);
    UserDTO getLoggedInUser(String email);

    User register(BasicUserRegistration basicUserRegistration);

    UserDTO connectAccounts(String token, String userEmail);
}
