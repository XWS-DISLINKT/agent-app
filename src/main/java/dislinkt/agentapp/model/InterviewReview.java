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
    @GeneratedValue
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne()
    private User author;

    private int rating;

    private Difficulty difficulty;

    private double selectionProcessDurationInWeeks;

    private String title;

    private String hrInterview;

    private String technicalInterview;

    private LocalDateTime datePosted;
}
