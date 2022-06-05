package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.BasicUserRegistration;
import dislinkt.agentapp.dto.JwtAuthenticationDTO;
import dislinkt.agentapp.dto.UserDTO;
import dislinkt.agentapp.exception.ResourceConflictException;
import dislinkt.agentapp.model.User;
import dislinkt.agentapp.security.config.TokenUtils;
import dislinkt.agentapp.security.config.UserTokenState;
import dislinkt.agentapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    private final TokenUtils tokenUtils;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationDTO authenticationRequest, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(),
                authenticationRequest.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername());
        long expiresIn = tokenUtils.getExpiresIn();

        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody BasicUserRegistration userRequest, UriComponentsBuilder uriComponentsBuilder) {
        User user = this.userService.findByEmail(userRequest.getEmail());
        if (user != null) {
            throw new ResourceConflictException(userRequest.getEmail(), "User already exists!");
        }
        return new ResponseEntity<>(this.userService.register(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    @PreAuthorize("isAuthenticated()")
    public User loadByUsername(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping()
    public UserDTO user(Principal user) {
        if (user == null)
            return null;
        return this.userService.getLoggedInUser(user.getName());
    }

    @PreAuthorize("hasRole('ROLE_COMPANY_OWNER')")
    @PostMapping(value = "/connect-accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO connectAccounts(@RequestBody String token, Principal user) {
        return userService.connectAccounts(token, user.getName());
    }
}
