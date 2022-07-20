package kr.hs.dgsw.AnimalForest.controller;

import kr.hs.dgsw.AnimalForest.DTO.BoardInsertDTO;
import kr.hs.dgsw.AnimalForest.DTO.BoardUpdateDTO;
import kr.hs.dgsw.AnimalForest.damain.Board;
import kr.hs.dgsw.AnimalForest.damain.ImageVO;
import kr.hs.dgsw.AnimalForest.mapper.ImageMapper;
import kr.hs.dgsw.AnimalForest.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final ImageMapper imageMapper;

    @PostMapping(value = "/post", consumes = "application/json;")
    public ResponseEntity<String> post(@RequestBody BoardInsertDTO boardInsertDTO, MultipartFile file) {

        try {

            Board board = boardService.insertBoard(boardInsertDTO);

            ImageVO imageVO = new ImageVO();
            imageVO.setMimetype(file.getContentType());
            imageVO.setOriginal_name(file.getOriginalFilename());
            imageVO.setData(file.getBytes());
            imageMapper.insertBoard(imageVO);
            imageVO.setBoard(board);

            return new ResponseEntity(board, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Board> update(@RequestBody @Valid BoardUpdateDTO boardUpdateDTO) {

        try {

            Board board = boardService.updateBoard(boardUpdateDTO);
            return new ResponseEntity(board, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long id) {

        try {

            boardService.deleteBoard(id);
            return new ResponseEntity(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
