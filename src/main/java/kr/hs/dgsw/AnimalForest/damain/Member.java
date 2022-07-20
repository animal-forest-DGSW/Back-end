package kr.hs.dgsw.AnimalForest.damain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    private LocalDate regDate;

    @NotNull
    private String role;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public Member(String name, String password) {
        this.name = name;
        this.password = password;
        this.regDate = LocalDate.now();
        this.role = "ROLE_USER";
    }
}
