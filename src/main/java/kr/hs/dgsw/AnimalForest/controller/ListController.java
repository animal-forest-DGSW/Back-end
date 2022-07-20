package kr.hs.dgsw.AnimalForest.controller;

import kr.hs.dgsw.AnimalForest.damain.Board;
import kr.hs.dgsw.AnimalForest.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListController {

    private final BoardService boardService;

    @GetMapping("list")
    public ResponseEntity<List<Board>> list(@RequestParam(defaultValue = "") String title,
                                            @RequestParam(defaultValue = "") String classification,
                                            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        try {

            List<Board> boards;

            if(classification.equals("")) {
                boards = boardService.boardList(title, pageable);
            } else {
                boards = boardService.boardListCla(title, classification, pageable);
            }
            return new ResponseEntity<>(boards, HttpStatus.OK);

        }  catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
