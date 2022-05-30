package dislinkt.agentapp.security.config;

import dislinkt.agentapp.service.impl.CustomUserService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    protected final Log LOGGER = LogFactory.getLog(getClass());
    private TokenUtils tokenUtils;
    private CustomUserService customUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username;
        String authorizationHeader = request.getHeader("Authorization");
        String authToken = tokenUtils.getToken(request);

        try {
            if (authToken != null) {
                username = tokenUtils.getUsernameFromToken(authToken);
                if (username != null) {
                    UserDetails userDetails = customUserService.loadUserByUsername(username);
                    if (this.tokenUtils.validateToken(authToken, userDetails)) {
                        TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                        authentication.setToken(authToken);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        } catch (ExpiredJwtException ex) {
            LOGGER.debug("Token expired!");
        }

        filterChain.doFilter(request, response);
    }
}
