package dislinkt.agentapp.dto;

import dislinkt.agentapp.model.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewInterviewReviewDTO {
    private int companyId;
    private int rating;
    private Difficulty difficulty;
    //private double selectionProcessDurationInWeeks;
    private String title;
    private String hrInterview;
    private String technicalInterview;
}
