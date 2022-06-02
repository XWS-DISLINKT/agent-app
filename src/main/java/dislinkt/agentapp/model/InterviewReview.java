package dislinkt.agentapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "interviewReviews")
public class InterviewReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name="rating")
    private int rating;

    @Column(name="difficulty")
    //@Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(name="selectionProcessDurationInWeeks")
    private double selectionProcessDurationInWeeks;

    @Column(name="title")
    private String title;

    @Column(name="hrInterview")
    private String hrInterview;

    @Column(name="technicalInterview")
    private String technicalInterview;

    @Column(name="datePosted", columnDefinition = "TIMESTAMP")
    private Date datePosted;
}
