package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.dto.BasicUserRegistration;
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
        user.setRoles(roleRepository.findByName(basicUserRegistration.getRole()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}