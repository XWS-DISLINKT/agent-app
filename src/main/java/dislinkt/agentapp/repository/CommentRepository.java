package dislinkt.agentapp.repository;

import dislinkt.agentapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment, Integer> {
    List<Comment> getByCompanyId(Integer companyId);
}
