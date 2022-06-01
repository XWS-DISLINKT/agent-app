package dislinkt.agentapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
public class Job {
    @Id
    @Column(name="id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="position")
    private String position;

    @Column(name="seniority")
    @Enumerated(EnumType.STRING)
    private Seniority seniority;

    @Column(name="location")
    private String location;

    @Column(name="description")
    private String description;

    @Column(name="closingDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime closingDate;

    @Column(name="technologies")
    @ElementCollection(targetClass=String.class)
    private List<String> technologies;
}
