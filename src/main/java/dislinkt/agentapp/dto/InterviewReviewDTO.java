package dislinkt.agentapp.dto;

import dislinkt.agentapp.model.Difficulty;
import dislinkt.agentapp.model.InterviewReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewReviewDTO {
    private Integer id;
    private String authorEmail;
    private int companyId;
    private int rating;
    private Difficulty difficulty;
    private double selectionProcessDurationInWeeks;
    private String title;
    private String hrInterview;
    private String technicalInterview;
    private Date datePosted;

    public InterviewReviewDTO(InterviewReview ir){
        id = ir.getId();
        authorEmail = ir.getAuthor().getEmail();
        companyId = ir.getCompany().getId();
        rating = ir.getRating();
        difficulty = ir.getDifficulty();
        selectionProcessDurationInWeeks = ir.getSelectionProcessDurationInWeeks();
        title = ir.getTitle();
        hrInterview = ir.getHrInterview();
        technicalInterview = ir.getTechnicalInterview();
        datePosted = ir.getDatePosted();
    }
}
