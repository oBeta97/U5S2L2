package EPICODE.U5S2L2.payloads;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BlogPostPayload {

    private String category;
    private String title;
    @Setter(AccessLevel.NONE)
    private String cover;
    private String content;
    private int readTime;

    public BlogPostPayload(String category, String title, String content, int readTime) {
        this.category = category;
        this.title = title;
        setCover();
        this.content = content;
        this.readTime = readTime;
    }

    public BlogPostPayload(BlogPostPayload bpp){
        this.category = bpp.category;
        this.title = bpp.title;
        setCover();
        this.content = bpp.content;
        this.readTime = bpp.readTime;
    }

    public void setCover(){
        this.cover = "https://picsum.photos/200/300";
    }

}
