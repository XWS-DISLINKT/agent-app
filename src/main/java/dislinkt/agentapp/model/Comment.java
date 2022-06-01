package dislinkt.agentapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, unique = true)
    private Integer id;

    //@ManyToOne(targetEntity = User.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name="rating")
    private int rating;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="datePosted", columnDefinition = "TIMESTAMP")
    private LocalDateTime datePosted;

}
