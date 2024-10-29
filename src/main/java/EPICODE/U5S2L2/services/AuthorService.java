package EPICODE.U5S2L2.services;

import EPICODE.U5S2L2.U5S2L2Application;
import EPICODE.U5S2L2.entities.Author;
import EPICODE.U5S2L2.entities.Author;
import EPICODE.U5S2L2.payloads.AuthorPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private List<Author> authorList = new ArrayList<>();

    public List<Author> findAll(){
        return this.authorList;
    }

    public Author findById(long id){

        Optional<Author> res = this.authorList.stream()
                .filter(bp -> id == bp.getId())
                .findFirst();

        if (res.isEmpty()) throw new RuntimeException("Author non trovato");

        return res.get();
    }


    public List<Author> saveAuthor (List<AuthorPayload> payloadList){

        List<Author> res = new ArrayList<>();

        for(AuthorPayload payload : payloadList){
            Author bp = new Author(payload);
            bp.setId(U5S2L2Application.r.nextInt(0,1000));

            authorList.add(bp);
            res.add(bp);
        }

        return res;
    }

    public Author updateList(AuthorPayload bpp, long idToUpdate){

        this.deleteAuthor(idToUpdate);

        // create the updated Author
        Author bp = new Author(bpp);
        bp.setId(idToUpdate);

        // add updated Author to the "DB"
        this.authorList.add(bp);

        return bp;

    }

    public Author deleteAuthor(long idToDelete){

        // check if the Author exist
        Author res = this.findById(idToDelete);

        // remove the Author to the "DB"
        this.authorList = new ArrayList<>(this.authorList.stream().filter(b -> b.getId() != idToDelete).toList());

        return res;
    }



}
