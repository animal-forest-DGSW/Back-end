package kr.hs.dgsw.AnimalForest.damain;

import com.sun.istack.NotNull;
import kr.hs.dgsw.AnimalForest.damain.enum_package.Classification;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private Classification classification;

    @NotNull
    private String type;

    @NotNull
    private LocalDate regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(mappedBy = "board")
    private ImageVO imageVO;

    @Builder
    public Board(String title, String content, Classification classification, String type, Member member) {
        this.title = title;
        this.content = content;
        this.classification = classification;
        this.type = type;
        this.regDate = LocalDate.now();
        postBoard(member);
    }

    private void postBoard(Member member) {
        this.member = member;
        member.getBoards().add(this);
    }

    public void update(String title, String content, Classification classification, String type) {
        this.title = title;
        this.content = content;
        this.classification = classification;
        this.type = type;
    }
}
