package kr.hs.dgsw.AnimalForest.service.board;

import kr.hs.dgsw.AnimalForest.DTO.BoardInsertDTO;
import kr.hs.dgsw.AnimalForest.DTO.BoardUpdateDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class BoardServiceImplTest {

    @Autowired BoardServiceImpl boardService;

    @Test
    @Rollback(false)
    public void 글_올리기() throws Exception {
        //given
        BoardInsertDTO boardInsertDTO = BoardInsertDTO.builder()
                .title("test")
                .content("test")
                .classification("SMALL")
                .type("고양이")
                .memberId(2L)
                .build();

        //when
        boardService.insertBoard(boardInsertDTO);

    }

    @Test
    @Rollback(false)
    public void 글_수정() throws Exception {
        BoardUpdateDTO boardUpdateDTO = BoardUpdateDTO.builder()
                .title("test")
                .content("test")
                .classification("SMALL")
                .type("강아지")
                .boardId(11L)
                .build();

        //when
        boardService.updateBoard(boardUpdateDTO);

    }

    @Test
    @Rollback(false)
    public void 글_삭제() throws Exception {
        //when
        boardService.deleteBoard(11L);
    }
}