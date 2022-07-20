package kr.hs.dgsw.AnimalForest.service.member;

import kr.hs.dgsw.AnimalForest.damain.Member;
import kr.hs.dgsw.AnimalForest.DTO.MemberDTO;
import kr.hs.dgsw.AnimalForest.exception.DuplicateNameException;
import kr.hs.dgsw.AnimalForest.exception.LoginException;

public interface MemberService {
    public void join(MemberDTO memberDTO) throws DuplicateNameException;
    public Member findById(Long id) throws Exception;
}
