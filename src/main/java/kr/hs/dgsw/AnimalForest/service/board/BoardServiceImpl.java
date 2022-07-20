package kr.hs.dgsw.AnimalForest.service.board;

import kr.hs.dgsw.AnimalForest.DTO.BoardInsertDTO;
import kr.hs.dgsw.AnimalForest.DTO.BoardUpdateDTO;
import kr.hs.dgsw.AnimalForest.damain.Board;
import kr.hs.dgsw.AnimalForest.damain.Member;
import kr.hs.dgsw.AnimalForest.damain.enum_package.Classification;
import kr.hs.dgsw.AnimalForest.service.member.MemberServiceImpl;
import kr.hs.dgsw.AnimalForest.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final MemberServiceImpl memberService;

    @Override
    public Board insertBoard(BoardInsertDTO boardDTO) throws Exception {

        Member member = memberService.findById(boardDTO.getMemberId());

        Board board = Board.builder()
                .content(boardDTO.getContent())
                .title(boardDTO.getTitle())
                .classification(Classification.valueOf(boardDTO.getClassification()))
                .type(boardDTO.getType())
                .member(member)
                .build();

        boardRepository.save(board);

        return board;
    }

    @Override
    public Board updateBoard(BoardUpdateDTO boardDTO) throws Exception {

        Board board = this.findById(boardDTO.getBoardId());
        board.update(boardDTO.getTitle(), boardDTO.getContent(), Classification.valueOf(boardDTO.getClassification()), boardDTO.getType());

        return board;
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        boardRepository.delete(this.findById(id));
    }

    @Override
    public Board findById(Long id) throws Exception {
        return boardRepository.findById(id).orElseThrow(() -> new Exception("존재하지 않는 글"));
    }

    @Override
    public List<Board> boardListCla(String title, String classification, Pageable pageable) {
        return boardRepository.findByTitleContainingAndClassification(title, Classification.valueOf(classification), pageable);
    }

    @Override
    public List<Board> boardList(String title, Pageable pageable) {
        return boardRepository.findByTitleContaining(title, pageable);
    }
}
