package EPICODE.U5S2L2.controllers;

import EPICODE.U5S2L2.entities.Author;
import EPICODE.U5S2L2.exceptions.NotFoundException;
import EPICODE.U5S2L2.payloads.AuthorPayload;
import EPICODE.U5S2L2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService as;

    @GetMapping
    public Page<Author> readAuthor(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ){
        return as.findAll(page, size, sortBy);
    }

    @GetMapping("/{AuthorId}")
    public Author readSingleAuthor(@PathVariable long AuthorId) throws NotFoundException {
        return as.findById(AuthorId);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Author> createAuthor(@RequestBody List<AuthorPayload> body){
        return as.saveAuthor(body);
    }

    @PutMapping("/{AuthorId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Author updateAuthor(@RequestBody AuthorPayload body, @PathVariable long AuthorId){
        return as.updateList(body, AuthorId);
    }

    @DeleteMapping("/{AuthorId}")
    @ResponseStatus(HttpStatus.GONE)
    public Author deleteAuthor(@PathVariable long AuthorId){
        return as.deleteAuthor(AuthorId);
    }


}
