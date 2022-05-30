package dislinkt.agentapp.security.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserTokenState {

    private String accessToken;
    private Long expiresIn;

    public UserTokenState() {
        this.accessToken = null;
        this.expiresIn = null;
    }
}
