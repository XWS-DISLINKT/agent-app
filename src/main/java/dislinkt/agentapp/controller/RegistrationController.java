package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.BasicUserRegistration;
import dislinkt.agentapp.model.User;
import dislinkt.agentapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api/registration")
public class RegistrationController {
    private final UserServiceImpl registrationService;

    @Autowired
    public RegistrationController(UserServiceImpl registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<User> register(@Valid @RequestBody BasicUserRegistration basicUserRegistration) {
        return ResponseEntity.ok(registrationService.register(basicUserRegistration));
    }

}