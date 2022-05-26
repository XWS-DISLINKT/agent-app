package dislinkt.agentapp.service;

import dislinkt.agentapp.dto.BasicUserRegistration;
import dislinkt.agentapp.dto.mapper.BasicUserRegistrationMapper;
import dislinkt.agentapp.model.BasicUser;
import dislinkt.agentapp.repository.BasicUserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    BasicUserRepository basicUserRepository;

    public RegistrationService(BasicUserRepository basicUserRepository) {
        this.basicUserRepository = basicUserRepository;
    }

    public BasicUser register(BasicUserRegistration basicUserRegistration) {
        var user = BasicUserRegistrationMapper.map(basicUserRegistration);
        return basicUserRepository.save(user);
    }
}
