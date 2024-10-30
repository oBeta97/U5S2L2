package EPICODE.U5S2L2.repositories;

import EPICODE.U5S2L2.entities.Author;
import EPICODE.U5S2L2.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
