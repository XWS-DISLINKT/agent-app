package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.dto.NewCommentDTO;
import dislinkt.agentapp.model.Comment;
import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.model.User;
import dislinkt.agentapp.repository.CommentRepository;
import dislinkt.agentapp.service.CommentService;
import dislinkt.agentapp.service.CompanyService;
import dislinkt.agentapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final CompanyService companyService;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment createComment(NewCommentDTO commentDto, String userEmail) {
        User user = userService.findByEmail(userEmail);
        Company company = companyService.getCompany(commentDto.getCompanyId());
        Comment newComment = Comment.builder()
                .author(user)
                .company(company)
                .content(commentDto.getContent())
                .datePosted(new Date())
                .title(commentDto.getTitle())
                .rating(commentDto.getRating())
                .build();
        commentRepository.save(newComment);
        return newComment;
    }
}
