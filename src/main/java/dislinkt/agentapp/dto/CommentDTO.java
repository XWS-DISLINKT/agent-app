package dislinkt.agentapp.dto;

import dislinkt.agentapp.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Integer id;
    private String authorEmail;
    private int companyId;
    private int rating;
    private String title;
    private String content;
    private Date datePosted;

    public CommentDTO(Comment comment){
        id = comment.getId();
        authorEmail = comment.getAuthor().getEmail();
        companyId = comment.getCompany().getId();
        rating = comment.getRating();
        title = comment.getTitle();
        content = comment.getContent();
        datePosted = comment.getDatePosted();
    }
}
