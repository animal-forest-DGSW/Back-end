package kr.hs.dgsw.AnimalForest.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardInsertDTO {

    @NotNull
    private Long memberId;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String classification;

    @NotBlank
    private String type;

    private MultipartFile file;

    @Builder
    public BoardInsertDTO(String title, String content, String classification, String type, Long memberId) {
        this.title = title;
        this.content = content;
        this.classification = classification;
        this.type = type;
        this.memberId = memberId;
    }
}
