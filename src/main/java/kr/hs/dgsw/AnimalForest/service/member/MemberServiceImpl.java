package kr.hs.dgsw.AnimalForest.service.member;

import com.sun.jdi.request.DuplicateRequestException;
import kr.hs.dgsw.AnimalForest.damain.Member;
import kr.hs.dgsw.AnimalForest.repository.MemberRepository;
import kr.hs.dgsw.AnimalForest.DTO.MemberDTO;
import kr.hs.dgsw.AnimalForest.exception.DuplicateNameException;
import kr.hs.dgsw.AnimalForest.exception.LoginException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void join(MemberDTO memberDTO) {
        if (memberRepository.existsByName(memberDTO.getName())) {
            throw new DuplicateRequestException("이미 존재하는 이름입니다.");
        }

//        if(!memberRepository.findByName(memberDTO.getName()).isEmpty()) {
//            throw new DuplicateNameException("이미 존재하는 이름입니다.");
//        }

        /*String rawPassword = memberDTO.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);*/

        String rawPassword = memberDTO.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        Member member = Member.builder()
                .name(memberDTO.getName())
                .password(encPassword)
                .build();

        memberRepository.save(member);
    }

    @Override
    public Member findById(Long id) throws Exception {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalStateException("존재하지 않는 회원"));
    }
}
