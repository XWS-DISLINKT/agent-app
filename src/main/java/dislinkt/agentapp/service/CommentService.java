package dislinkt.agentapp.service;


import dislinkt.agentapp.dto.NewCommentDTO;
import dislinkt.agentapp.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    Comment createComment(NewCommentDTO comment, String userEmail);
}
