package dislinkt.agentapp.model;

import javax.persistence.*;

@Entity
public class CompanyOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
