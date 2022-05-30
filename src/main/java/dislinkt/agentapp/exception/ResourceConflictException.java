package dislinkt.agentapp.exception;

import lombok.Data;

@Data
public class ResourceConflictException extends RuntimeException {
    private String resourceUsername;

    public ResourceConflictException(String username, String message) {
        super(message);
        setResourceUsername(username);
    }
}
