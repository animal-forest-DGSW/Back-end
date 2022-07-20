package kr.hs.dgsw.AnimalForest.DTO;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class MemberDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @Builder
    public MemberDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
