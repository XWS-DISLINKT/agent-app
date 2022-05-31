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
    @GeneratedValue
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    private String position;

    private double monthlySalaryEur;
}
