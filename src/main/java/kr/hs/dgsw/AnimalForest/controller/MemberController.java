package kr.hs.dgsw.AnimalForest.controller;

import kr.hs.dgsw.AnimalForest.DTO.MemberDTO;
import kr.hs.dgsw.AnimalForest.exception.DuplicateNameException;
import kr.hs.dgsw.AnimalForest.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/join")
    public void join(@RequestBody @Valid MemberDTO memberDTO) throws DuplicateNameException {

        //try {

        System.out.println(memberDTO.toString());
        System.out.println(memberDTO.getName());
        System.out.println(memberDTO.getPassword());
            memberService.join(memberDTO);
//            return new ResponseEntity(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
    }
}
