package dislinkt.agentapp.service;


import dislinkt.agentapp.dto.CommentDTO;
import dislinkt.agentapp.dto.NewCommentDTO;
import dislinkt.agentapp.model.Comment;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getAllCommentsForCompany(int companyId);
    CommentDTO createComment(NewCommentDTO comment, String userEmail);
}
