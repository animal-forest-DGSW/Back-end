package kr.hs.dgsw.AnimalForest.service.board;

import kr.hs.dgsw.AnimalForest.DTO.BoardInsertDTO;
import kr.hs.dgsw.AnimalForest.damain.Board;
import kr.hs.dgsw.AnimalForest.DTO.BoardUpdateDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    public Board insertBoard(BoardInsertDTO boardDTO) throws Exception;
    public Board updateBoard(BoardUpdateDTO boardDTO) throws Exception;
    public void deleteBoard(Long id) throws Exception;
    public Board findById(Long id) throws Exception;
    List<Board> boardListCla(String title, String classification, Pageable pageable);
    List<Board> boardList(String title, Pageable pageable);
}
