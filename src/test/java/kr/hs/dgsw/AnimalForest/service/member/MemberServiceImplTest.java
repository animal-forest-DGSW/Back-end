package kr.hs.dgsw.AnimalForest.service.member;

import kr.hs.dgsw.AnimalForest.DTO.MemberDTO;
import kr.hs.dgsw.AnimalForest.exception.DuplicateNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired MemberService memberService;

    @Test
    @Rollback(false)
    public void 회원가입() throws DuplicateNameException {
        //given
        MemberDTO memberDTO = createMemberDTO("test111");

        //when
        memberService.join(memberDTO);

    }

    @Test
    //이미 존재하는 이름을 넣었을 경우
    public void 회원가입_오류1() throws DuplicateNameException {
        //given
        MemberDTO memberDTO1 = createMemberDTO("test112");
        memberService.join(memberDTO1);

        MemberDTO memberDTO2 = createMemberDTO("test112");

        //then
        assertThrows(DuplicateNameException.class, () -> memberService.join(memberDTO2));

    }

    private MemberDTO createMemberDTO(String name) {
        return MemberDTO.builder()
                .name(name)
                .password("test")
                .build();
    }
}