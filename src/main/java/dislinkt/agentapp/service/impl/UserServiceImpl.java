package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.dto.BasicUserRegistration;
import dislinkt.agentapp.dto.UserDTO;
import dislinkt.agentapp.dto.mapper.BasicUserRegistrationMapper;
import dislinkt.agentapp.model.User;
import dislinkt.agentapp.repository.RoleRepository;
import dislinkt.agentapp.repository.UserRepository;
import dislinkt.agentapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public User register(BasicUserRegistration basicUserRegistration) {
        var user = BasicUserRegistrationMapper.map(basicUserRegistration);
        user.setPassword(passwordEncoder.encode(basicUserRegistration.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_CLIENT"));
        return userRepository.save(user);
    }

    @Override
    public UserDTO connectAccounts(String token, String email) {
        User user = userRepository.findByEmail(email);
        user.setConnectionToken(token);
        userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public UserDTO getLoggedInUser(String email) {
        return new UserDTO(userRepository.findByEmail(email));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
