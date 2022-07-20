package kr.hs.dgsw.AnimalForest.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardUpdateDTO {

    @NotNull
    private Long boardId;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String classification;

    @NotBlank
    private String type;

    @Builder
    public BoardUpdateDTO(String title, String content, String classification, String type, Long boardId) {
        this.title = title;
        this.content = content;
        this.classification = classification;
        this.type = type;
        this.boardId = boardId;
    }
}
