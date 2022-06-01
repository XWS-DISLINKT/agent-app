package dislinkt.agentapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interviewReviews")
public class InterviewReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private User author;

    @Column(name="rating")
    private int rating;

    @Column(name="difficulty")
    @Enumerated(EnumType.STRING)
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
    private LocalDateTime datePosted;
}
