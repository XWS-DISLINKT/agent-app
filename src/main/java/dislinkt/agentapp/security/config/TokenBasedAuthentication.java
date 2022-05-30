package dislinkt.agentapp.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class TokenBasedAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 1L;
    private final UserDetails principal;
    @Getter @Setter private String token;

    public TokenBasedAuthentication(UserDetails principle) {
        super(principle.getAuthorities());
        this.principal = principle;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
