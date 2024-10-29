package EPICODE.U5S2L2.entities;


import EPICODE.U5S2L2.payloads.AuthorPayload;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author extends AuthorPayload {

    private long id;

    public Author(String name, String surname, String email, LocalDate birthDay, String avatar) {
        super(name, surname, email, birthDay);
    }

    public Author(AuthorPayload ap) {
        super(ap);
    }
}
