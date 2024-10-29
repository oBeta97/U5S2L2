package EPICODE.U5S2L2.payloads;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuthorPayload {

    private String name;
    private String surname;
    private String email;
    private LocalDate birthDay;
    @Setter(AccessLevel.NONE)
    private String avatar;

    public AuthorPayload(String name, String surname, String email, LocalDate birthDay) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDay = birthDay;
        this.avatar = avatar;
    }

    public AuthorPayload(AuthorPayload ap) {
        this.name = ap.name;
        this.surname = ap.surname;
        this.email = ap.email;
        this.birthDay = ap.birthDay;
        setAvatar();
    }

    public void setAvatar() {
        this.avatar = "https://ui-avatars.com/api/?name%3DMario%2BRossi";
    }
}
