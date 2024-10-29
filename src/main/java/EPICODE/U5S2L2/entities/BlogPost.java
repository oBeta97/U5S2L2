package EPICODE.U5S2L2.entities;

import EPICODE.U5S2L2.payloads.BlogPostPayload;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BlogPost extends BlogPostPayload {

    private long id;

    public BlogPost(String category, String title, String content, int readTime) {
        super(category, title, content, readTime);
    }

    public BlogPost(BlogPostPayload bpp) {
        super(bpp);
    }

}
