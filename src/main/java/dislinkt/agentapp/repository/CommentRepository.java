package dislinkt.agentapp.repository;

import dislinkt.agentapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment, Integer> {
}
