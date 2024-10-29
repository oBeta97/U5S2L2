package EPICODE.U5S2L2.services;

import EPICODE.U5S2L2.U5S2L2Application;
import EPICODE.U5S2L2.entities.BlogPost;
import EPICODE.U5S2L2.payloads.BlogPostPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogPostService {

    private List<BlogPost> blogPostList = new ArrayList<>();

    public List<BlogPost> findAll(){
        return this.blogPostList;
    }

    public BlogPost findById(long id){

        Optional<BlogPost> res = this.blogPostList.stream()
                .filter(bp -> id == bp.getId())
                .findFirst();

        if (res.isEmpty()) throw new RuntimeException("blogpost non trovato");

        return res.get();
    }


    public List<BlogPost> saveBlogPost (List<BlogPostPayload> payloadList){

        List<BlogPost> res = new ArrayList<>();

        for(BlogPostPayload payload : payloadList){
            BlogPost bp = new BlogPost(payload);
            bp.setId(U5S2L2Application.r.nextInt(0,1000));

            blogPostList.add(bp);
            res.add(bp);
        }

        return res;
    }

    public BlogPost updateList(BlogPostPayload bpp, long idToUpdate){

        this.deleteBlogPost(idToUpdate);

        // create the updated blogpost
        BlogPost bp = new BlogPost(bpp);
        bp.setId(idToUpdate);

        // add updated blogpost to the "DB"
        this.blogPostList.add(bp);

        return bp;

    }

    public BlogPost deleteBlogPost(long idToDelete){

        // check if the blogpost exist
        BlogPost res = this.findById(idToDelete);

        // remove the blogpost to the "DB"
        this.blogPostList = new ArrayList<>(this.blogPostList.stream().filter(b -> b.getId() != idToDelete).toList());

        return res;
    }



}
