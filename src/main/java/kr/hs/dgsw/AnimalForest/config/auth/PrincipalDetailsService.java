package kr.hs.dgsw.AnimalForest.config.auth;

import kr.hs.dgsw.AnimalForest.damain.Member;
import kr.hs.dgsw.AnimalForest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(username + "   446");
        Member memberEntity = memberRepository.getMemberByName(username);
        System.out.println(memberEntity);

        if(memberEntity != null) {
            return new PrincipalDetails(memberEntity);
        }
        return null;
    }

}
