package dislinkt.agentapp.service.impl;

import dislinkt.agentapp.dto.CommentDTO;
import dislinkt.agentapp.dto.NewCommentDTO;
import dislinkt.agentapp.model.Comment;
import dislinkt.agentapp.model.Company;
import dislinkt.agentapp.model.User;
import dislinkt.agentapp.repository.CommentRepository;
import dislinkt.agentapp.repository.CompanyRepository;
import dislinkt.agentapp.service.CommentService;
import dislinkt.agentapp.service.CompanyService;
import dislinkt.agentapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CompanyRepository companyRepository;
    private final UserService userService;

    @Override
    public List<CommentDTO> getAllCommentsForCompany(int companyId) {
        List<Comment> comments = commentRepository.getByCompanyId(companyId);
        List<CommentDTO> commentsDto = new ArrayList<>();
        for (Comment c: comments) {
            commentsDto.add(new CommentDTO(c));
        }
        return commentsDto;
    }

    @Override
    public CommentDTO createComment(NewCommentDTO commentDto, String userEmail) {
        User user = userService.findByEmail(userEmail);
        Company company = companyRepository.findById(commentDto.getCompanyId()).orElse(null);
        Comment newComment = Comment.builder()
                .author(user)
                .company(company)
                .content(commentDto.getContent())
                .datePosted(new Date())
                .title(commentDto.getTitle())
                .rating(commentDto.getRating())
                .build();
        commentRepository.save(newComment);
        return new CommentDTO(newComment);
    }

    @Override
    public double getAvarageRating(int companyId) {
        List<Comment> comments = commentRepository.getByCompanyId(companyId);
        double sum = 0;
        int i = 0;
        for (Comment c : comments) {
            sum += c.getRating();
            i++;
        }
        if (sum == 0)
            return 0.0;
        return sum/i;
    }
}
