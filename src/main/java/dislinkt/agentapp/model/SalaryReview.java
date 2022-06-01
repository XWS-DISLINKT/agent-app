package dislinkt.agentapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salaryReviews")
public class SalaryReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    @Column(name="position")
    private String position;

    @Column(name="seniority")
    @Enumerated(EnumType.STRING)
    private Seniority seniority;

    @Column(name="monthlySalaryEur")
    private double monthlySalaryEur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;
}