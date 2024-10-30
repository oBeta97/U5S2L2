package EPICODE.U5S2L2.services;

import EPICODE.U5S2L2.U5S2L2Application;
import EPICODE.U5S2L2.entities.Author;
import EPICODE.U5S2L2.entities.BlogPost;
import EPICODE.U5S2L2.exceptions.NotFoundException;
import EPICODE.U5S2L2.payloads.BlogPostPayload;
import EPICODE.U5S2L2.repositories.AuthorRepository;
import EPICODE.U5S2L2.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepo;

    @Autowired
    private AuthorRepository authorRepo;

    public List<BlogPost> findAll(){
        return blogPostRepo.findAll();
    }

    public BlogPost findById(long id){

        Optional<BlogPost> res = blogPostRepo.findById(id);

        if (res.isEmpty()) throw new NotFoundException(BlogPost.class);

        return res.get();
    }


    public List<BlogPost> saveBlogPost (List<BlogPostPayload> payloadList, long authorId){

        List<BlogPost> res = new ArrayList<>();

        for(BlogPostPayload payload : payloadList){
            BlogPost bp = new BlogPost(payload);
            bp.setId(U5S2L2Application.r.nextInt(0,1000));

            blogPostRepo.save(bp);
            res.add(bp);
        }

        return res;
    }

    public BlogPost updateList(BlogPostPayload bpp, long idToUpdate){

        // check if the Author exist
        this.findById(idToUpdate);

        // Create an Author obj by the payload
        BlogPost res = new BlogPost(bpp);
        res.setId(idToUpdate);

        // save in this case will update the existing row
        return blogPostRepo.save(res);

    }

    public BlogPost deleteBlogPost(long idToDelete){

        // check if the blogpost exist
        BlogPost res = this.findById(idToDelete);

        // remove the blogpost to the "DB"
        blogPostRepo.deleteById(idToDelete);

        return res;
    }



}
