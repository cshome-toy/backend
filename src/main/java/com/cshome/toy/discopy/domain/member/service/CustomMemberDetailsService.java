package com.cshome.toy.discopy.domain.member.service;

import com.cshome.toy.discopy.domain.member.dto.MemberDetails;
import com.cshome.toy.discopy.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomMemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findByEmail(email)
                .map(MemberDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 회원 찾을 수 없습니다."));
    }


}
