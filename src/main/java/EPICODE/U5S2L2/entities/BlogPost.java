package EPICODE.U5S2L2.entities;

import EPICODE.U5S2L2.payloads.BlogPostPayload;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "blogposts")
public class BlogPost extends BlogPostPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorId;

    public BlogPost(String category, String title, String content, int readTime) {
        super(category, title, content, readTime);
    }

    public BlogPost(BlogPostPayload bpp) {
        super(bpp);
    }

    public BlogPost(BlogPostPayload bpp, Author author) {
        super(bpp);
        this.setAuthorId(author);
    }

}
