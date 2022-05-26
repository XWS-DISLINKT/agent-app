package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.BasicUserRegistration;
import dislinkt.agentapp.model.BasicUser;
import dislinkt.agentapp.repository.BasicUserRepository;
import dislinkt.agentapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<BasicUser> register(@Valid @RequestBody BasicUserRegistration basicUserRegistration) {
        return ResponseEntity.ok(registrationService.register(basicUserRegistration));
    }

}