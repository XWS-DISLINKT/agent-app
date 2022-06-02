package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.NewCommentDTO;
import dislinkt.agentapp.model.Comment;
import dislinkt.agentapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/comment")
public class CommentController {
    private final CommentService commentService;

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping("")
    public Comment createComment(@RequestBody NewCommentDTO comment, Principal user) {
        return commentService.createComment(comment, user.getName());
    }
}
