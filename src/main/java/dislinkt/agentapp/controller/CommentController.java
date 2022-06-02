package dislinkt.agentapp.controller;

import dislinkt.agentapp.dto.CommentDTO;
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

    @GetMapping("/company/{companyId}")
    public List<CommentDTO> getAllCommentsForCompany(@PathVariable int companyId) {
        return commentService.getAllCommentsForCompany(companyId);
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping("")
    public CommentDTO createComment(@RequestBody NewCommentDTO comment, Principal user) {
        return commentService.createComment(comment, user.getName());
    }
}
