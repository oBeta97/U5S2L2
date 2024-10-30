package EPICODE.U5S2L2.services;

import EPICODE.U5S2L2.U5S2L2Application;
import EPICODE.U5S2L2.entities.Author;
import EPICODE.U5S2L2.entities.Author;
import EPICODE.U5S2L2.exceptions.NotFoundException;
import EPICODE.U5S2L2.payloads.AuthorPayload;
import EPICODE.U5S2L2.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepo;

    public Page<Author> findAll(int page, int size, String sortBy){

        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));

        return this.authorRepo.findAll(pageable);
    }

    public Author findById(long id) {

        Optional<Author> res = authorRepo.findById(id);

        if (res.isEmpty()) throw new NotFoundException(Author.class);

        return res.get();
    }


    public List<Author> saveAuthor (List<AuthorPayload> payloadList){

        List<Author> res = new ArrayList<>();

        for(AuthorPayload payload : payloadList){
            Author bp = new Author(payload);

            authorRepo.save(bp);
            res.add(bp);
        }

        return res;
    }

    public Author updateList(AuthorPayload bpp, long idToUpdate){

        // check if the Author exist
        this.findById(idToUpdate);

        // Create an Author obj by the payload
        Author res = new Author(bpp);
        res.setId(idToUpdate);

        // save in this case will update the existing row
        return authorRepo.save(res);

    }

    public Author deleteAuthor(long idToDelete){

        // check if the Author exist
        Author res = this.findById(idToDelete);

        // remove the Author to the "DB"
        authorRepo.deleteById(idToDelete);

        return res;
    }



}
