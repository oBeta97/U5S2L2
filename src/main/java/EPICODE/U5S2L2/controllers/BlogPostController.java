package EPICODE.U5S2L2.controllers;

import EPICODE.U5S2L2.entities.BlogPost;
import EPICODE.U5S2L2.payloads.BlogPostPayload;
import EPICODE.U5S2L2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogpost")
public class BlogPostController {

    @Autowired
    private BlogPostService bps;

    @GetMapping
    public List<BlogPost> readBlogPost(){
        return bps.findAll();
    }

    @GetMapping("/{blogPostId}")
    public BlogPost readSingleBlogPost(@PathVariable long blogPostId){
        return bps.findById(blogPostId);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<BlogPost> createBlogPost(@RequestBody List<BlogPostPayload> body){
        return bps.saveBlogPost(body);
    }

    @PutMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BlogPost updateBlogPost(@RequestBody BlogPostPayload body, @PathVariable long blogPostId){
        return bps.updateList(body, blogPostId);
    }

    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.GONE)
    public BlogPost deleteBlogPost(@PathVariable long blogPostId){
        return bps.deleteBlogPost(blogPostId);
    }


}
