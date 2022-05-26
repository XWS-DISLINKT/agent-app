package dislinkt.agentapp.model;

import javax.persistence.*;

@Entity
public class BasicUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;

    public BasicUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}