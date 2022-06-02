package dislinkt.agentapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCommentDTO {
    private int companyId;
    private int rating;
    private String title;
    private String content;
}
